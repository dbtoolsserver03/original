package com.suns.netty07;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class MyNettyClient1 {
    private static final Logger log = LoggerFactory.getLogger(MyNettyClient1.class);

    public static void main(String[] args) throws InterruptedException {
        log.debug("myNettyClientStarter------");
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        Bootstrap group = bootstrap.group(eventLoopGroup);//32 ---> 1 IO操作 31线程
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new LoggingHandler());
                ch.pipeline().addLast(new StringEncoder());
            }
        });

        Channel channel = bootstrap.connect(new InetSocketAddress(8000)).sync().channel();
        //半包？粘包？  1  0
        //粘包 --->ByteBuf(1024) ---> socket 65535 --- server
        channel.writeAndFlush("sunshuai\nxiaohei\nxiaojr\n");

    }
}