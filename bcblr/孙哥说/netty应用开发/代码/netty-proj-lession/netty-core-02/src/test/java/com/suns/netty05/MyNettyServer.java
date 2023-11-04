package com.suns.netty05;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyNettyServer {


    private static final Logger log = LoggerFactory.getLogger(MyNettyServer.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.group(new NioEventLoopGroup());

        /*
            1.  ServerSocketChannel--->accept ---> NioEventLoop 线程 boss ---> handler()
                handler()做啥呢？ handler 为ServerSocketChannel服务的 PipeLine ---> Handler
                1. 99% 这个handler方法 可以不写。
                2. 特殊需求 监控ServerScoketChannel -->handler() --Piplline方式处理。

            2.  SocketChannel      --->write read-->NioEventLoop 线程 worker --> childHandler()
                1. 与Client实际建立的 SocketChannel
                2. Pipl Line  --> Handler ---> 每一个SocketChannel 一份。

         */

      /*  serverBootstrap.handler(new ChannelInitializer<NioServerSocketChannel>() {

            @Override
            protected void initChannel(NioServerSocketChannel ch) throws Exception {

            }
        });*/

        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new StringDecoder());
                pipeline.addLast(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("{}", msg);
                        super.channelRead(ctx, msg);
                    }
                });

            }
        });
        serverBootstrap.bind(8000);
    }
}
