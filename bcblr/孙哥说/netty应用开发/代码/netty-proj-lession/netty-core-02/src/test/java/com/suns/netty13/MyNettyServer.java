package com.suns.netty13;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MyNettyServer {

    private static final Logger log = LoggerFactory.getLogger(MyNettyServer.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.group(new NioEventLoopGroup());
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //head  自定义1  自定义2  tail 5个
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new StringDecoder());
                //pipeline.addLast(new IdleStateHandler(3, 5, 7, TimeUnit.SECONDS));
                pipeline.addLast(new IdleStateHandler(0, 0, 15, TimeUnit.SECONDS));
                pipeline.addLast(new ChannelInboundHandlerAdapter() {
                    // 次数不成 记录时间 3次
                    // 10:30 1  11：00 2i次
                    //@Override
                    /*
                      作用：当发生了特定的空闲时间后，程序员的处理业务，写在这个方法中
                     */
              /*      public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                        IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
                        if (idleStateEvent.state() == IdleState.READER_IDLE) {
                            log.debug("读空闲... {} ", ctx.channel());
                        } else if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                            log.debug("写空闲... {} ", ctx.channel());
                        } else if (idleStateEvent.state() == IdleState.ALL_IDLE) {
                            log.debug("读写空闲... {} ", ctx.channel());
                        }
                    }*/

                    @Override
                    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                        IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
                        if (idleStateEvent.state() == IdleState.ALL_IDLE) {
                            log.debug("读写空闲 {} ",ctx.channel());
                            ctx.channel().close();

                            //业务处理 ---> 信息保存数据库中 断
                        }
                    }
                });


            }
        });
        serverBootstrap.bind(8000);
    }
}
