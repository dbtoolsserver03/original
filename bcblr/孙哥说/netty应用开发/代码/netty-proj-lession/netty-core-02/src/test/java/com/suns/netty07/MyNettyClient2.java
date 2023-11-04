package com.suns.netty07;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
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

public class MyNettyClient2 {
    private static final Logger log = LoggerFactory.getLogger(MyNettyClient2.class);

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

        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();

        String message = "hello sunshuai";
        // length 0 4
        buf.writeInt(message.length());
        // 特殊的头 1 1
        buf.writeByte(1);
        buf.writeBytes(message.getBytes());

        String message1 = "hello xiaohei";
        // length 0 4
        buf.writeInt(message1.length());
        // 特殊的头 1 1
        buf.writeByte(2);
        buf.writeBytes(message1.getBytes());

        channel.writeAndFlush(buf);





    }
}