package com.suns.netty02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyNettyServer {

    private static final Logger log = LoggerFactory.getLogger(MyNettyServer.class);

    public static void main(String[] args) {
        //主 accept 1
        EventLoopGroup bossEventGroup = new NioEventLoopGroup(1);
        //从 worker IO 多个
        EventLoopGroup workerEventGroup = new NioEventLoopGroup(3);

        //获得DefaultEventLoop
        DefaultEventLoopGroup defaultEventLoopGroup = new DefaultEventLoopGroup();


        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        //select accept write read 多线程的设置
        //线程池  EventLoop --> worker
        //serverBootstrap.group(new NioEventLoopGroup());
        serverBootstrap.group(bossEventGroup, workerEventGroup);
        //接受到 写数据前
        //handler进行处理。piplline--handler响应处理
        //handler使用 核心内容
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //read write channel
            // channel ---> accept 建立连接的操作
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder());
                ch.pipeline().addLast(defaultEventLoopGroup, new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("{}", msg);
                    }
                });
            }
        });
        serverBootstrap.bind(8000);
    }
}
