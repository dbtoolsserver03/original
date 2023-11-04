package com.suns.netty;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.suns.netty.codec.ChatByteToMessageDecoder;
import com.suns.netty.codec.ChatMessageToByteEncoder;
import com.suns.netty.message.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


@Slf4j
public class MyNettyClient {

    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        Scanner scanner = new Scanner(System.in);

        CountDownLatch WAIT_LOGIN = new CountDownLatch(1);
        AtomicBoolean LOGIN = new AtomicBoolean(false);
        AtomicBoolean SERVER_ERROR = new AtomicBoolean(false);

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 50);
            Bootstrap group = bootstrap.group(eventLoopGroup);
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 7, 4, 0, 0));
                    ch.pipeline().addLast(LOGGING_HANDLER);
                    ch.pipeline().addLast(new ChatMessageToByteEncoder());
                    ch.pipeline().addLast(new ChatByteToMessageDecoder());
                    ch.pipeline().addLast(new IdleStateHandler(8, 3, 0, TimeUnit.SECONDS));
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                        @Override
                        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
                            if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                                ctx.writeAndFlush(new PingMessage("client"));
                            } else if (idleStateEvent.state() == IdleState.READER_IDLE) {
                                log.debug("服务器端 已经8秒没有响应数据了。。。");
                                log.debug("关闭channel");
                                ctx.channel().close();

                                SERVER_ERROR.set(true);
                                /*
                                close.addListener(new ChannelFutureListener() {
                                    @Override
                                    public void operationComplete(ChannelFuture future) throws Exception {
                                         //进行重连
                                    }
                                });
                                close.addListener(promise->{

                                });
                                */
                            }

                        }
                    });
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {

                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            log.debug("recive data {}", msg);
                            if (msg instanceof LoginResponseMessage) {
                                LoginResponseMessage loginResponseMessage = (LoginResponseMessage) msg;
                                if (loginResponseMessage.getCode().equals("200")) {
                                    LOGIN.set(true);
                                }
                                WAIT_LOGIN.countDown();
                            }


                        }

                        @Override
                        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                            if (SERVER_ERROR.get()) {
                               /*
                               当前执行这行代码的线程 ，后续会被netty回收，所以在这里直接重连不好
                                Channel channel = bootstrap.connect(new InetSocketAddress(8000)).sync().channel();
                                channel.closeFuture().sync();
                                */
                                log.debug("重连...");

                                //等价于从EventLoopGroup中 从新获得了
                                EventLoop eventLoop = ctx.channel().eventLoop();
                                eventLoop.submit(() -> {
                                    Channel channel = null;
                                    try {
                                        ChannelFuture connect = bootstrap.connect(new InetSocketAddress(8000));

                                        connect.addListener(promise -> {
                                            //promise.isSuccess();
                                            log.debug("{} ", promise.cause());
                                        });

                                        Channel channel1 = connect.sync().channel();
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    try {
                                        channel.closeFuture().sync();
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                });


                            } else {
                                log.debug("client close ...");
                            }

                        }

                        @Override
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                            log.debug("client close....");
                            super.exceptionCaught(ctx, cause);
                        }

                        @Override
                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                            //用户名 密码 让用户输入 Scanner 输入
                            //用户的输入 菜单的展示  UI相关的内容
                            new Thread(() -> {
                                System.out.println("请输入用户名: ");
                                String username = scanner.nextLine();

                                System.out.println("请输入密码: ");
                                String password = scanner.nextLine();

                                //发送登录操作
                                LoginRequestMessage loginRequestMessage = new LoginRequestMessage(username, password);
                                ctx.writeAndFlush(loginRequestMessage);

                                try {
                                    WAIT_LOGIN.await();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }

                                if (!LOGIN.get()) {
                                    ctx.channel().close();
                                    return;
                                }

                                while (true) {
                                    System.out.println("========================================");
                                    System.out.println("send [username] [content]");
                                    System.out.println("gcreate [group name] [m1,m2,m3...]");
                                    System.out.println("gsend [group name] [content]");
                                    System.out.println("quit");
                                    System.out.println("========================================");

                                    String command = scanner.nextLine();
                                    String[] args = command.split(" ");
                                    switch (args[0]) {
                                        case "send":
                                            ctx.writeAndFlush(new ChatRequestMessage(username, args[1], args[2]));
                                            break;
                                        case "gcreate":
                                            String groupName = args[1];
                                            String[] membersString = args[2].split(",");
                                            Set<String> members = new HashSet<>(Arrays.asList(membersString));
                                            members.add(username);
                                            ctx.writeAndFlush(new GroupCreateRequestMessage(groupName, members));
                                            break;
                                        case "gsend":
                                            String gName = args[1];
                                            String content = args[2];
                                            ctx.writeAndFlush(new GroupChatRequestMessage(username, gName, content));
                                            break;
                                        case "quit":
                                            //服务器端 unbind
                                            ctx.channel().close();
                                            return;
                                    }

                                }


                            }, "Client UI").start();

                        }
                    });
                }
            });
            Channel channel = bootstrap.connect(new InetSocketAddress(8000)).sync().channel();
            channel.closeFuture().sync();
         /*   ChannelFuture connect = bootstrap.connect(new InetSocketAddress(8000));
            connect.addListener(promise -> {
                   if(!promise.isSuccess()){
                      //重试 3次
                   }else{
                       Channel channel = connect.channel();
                       channel.closeFuture().sync();
                   }
            });*/


        } catch (InterruptedException e) {
            log.error("client error ", e);
        } finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
}