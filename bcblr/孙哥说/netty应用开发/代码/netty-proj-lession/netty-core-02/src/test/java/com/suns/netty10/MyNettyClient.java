package com.suns.netty10;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class MyNettyClient {
    private static final Logger log = LoggerFactory.getLogger(MyNettyClient.class);

    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        log.debug("myNettyClientStarter------");
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        Bootstrap group = bootstrap.group(eventLoopGroup);
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new LoggingHandler());
                //自定义编码器
                //Encoderxxx
                ch.pipeline().addLast(new MyLongToByteEncoder());
                //编解码器 或者 handler 匿名的内部类 重用性差
                //内部类 ---> 使用范围 仅限于本类 （封装） Map  Map.Entry(key -- value)
                //ch.pipeline().addLast(new MyLongCodec());
            }
        });

        Channel channel = bootstrap.connect(new InetSocketAddress(8000)).sync().channel();
        channel.writeAndFlush("10-20");

    }
}