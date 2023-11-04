package com.suns.netty;

import com.suns.netty.codec.ChatByteToMessageDecoder;
import com.suns.netty.codec.ChatMessageToByteEncoder;
import com.suns.netty.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/*
RPC  ---> dubbo

Spring ---> 工厂的
SpringBoot应用 ---> 启动类 main ---> 服务端启动
1. 服务器 一定是一个 Bean
                      1. Handler注入
                      2. bean启动 ---> 生命周期 init()

                  @Import(Bean.class)--->spi

                  启动器 starter
                  1. 导入jar---> @Import()
                  2. AutoConfigure



 */
@Slf4j
public class MyNettyServer {

    public static void main(String[] args) {
        LoggingHandler LOGGING_HANDLER = new LoggingHandler();
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        LoginRequestMessageHandler LOGINREQUESTMESSAGEHANDLER = new LoginRequestMessageHandler();
        ChatRequestMessageHandler CHATREQUESTMESSAGEHANDLER = new ChatRequestMessageHandler();
        GroupCreateMessageHandler GROUPCREATEMESSAGEHANDLER = new GroupCreateMessageHandler();
        GroupChatRequestMessasgeHandler GROUPCHATREQUESTMESSASGEHANDLER = new GroupChatRequestMessasgeHandler();
        QuitHandler QUITHANDLER = new QuitHandler();


        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.group(bossGroup, workerGroup);
            serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new LengthFieldBasedFrameDecoder(1024, 7, 4, 0, 0));
                    pipeline.addLast(LOGGING_HANDLER);
                    pipeline.addLast(new ChatByteToMessageDecoder());
                    pipeline.addLast(new ChatMessageToByteEncoder());
                    pipeline.addLast(new IdleStateHandler(8, 3, 0, TimeUnit.SECONDS));
                    pipeline.addLast(new ChannelInboundHandlerAdapter() {
                        @Override
                        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
                            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                                log.debug("client已经8s没有与服务端通信..... ");
                                log.debug("关闭channel");
                                ctx.channel().close();
                            }else if(idleStateEvent.state() == IdleState.WRITER_IDLE){
                                //代码在实际开发中应该应用，但是为了模拟client的处理 暂时注释
                               //ctx.writeAndFlush(new PongMessage("server"));
                            }
                        }
                    });
                    pipeline.addLast(LOGINREQUESTMESSAGEHANDLER);
                    pipeline.addLast(CHATREQUESTMESSAGEHANDLER);
                    pipeline.addLast(GROUPCREATEMESSAGEHANDLER);
                    pipeline.addLast(GROUPCHATREQUESTMESSASGEHANDLER);
                    pipeline.addLast(QUITHANDLER);
                }
            });
            Channel channel = serverBootstrap.bind(8000).sync().channel();
            channel.closeFuture().sync();
        } catch (Exception e) {
            log.error("server error", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
