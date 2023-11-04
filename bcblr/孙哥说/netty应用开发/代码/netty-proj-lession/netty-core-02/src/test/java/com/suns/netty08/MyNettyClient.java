package com.suns.netty08;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class MyNettyClient {
    private static final Logger log = LoggerFactory.getLogger(MyNettyClient.class);

    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        log.debug("myNettyClientStarter------");
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        Bootstrap group = bootstrap.group(eventLoopGroup);//32 ---> 1 IO操作 31线程
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new LoggingHandler());
                //ch.pipeline().addLast(new ObjectEncoder());
            }
        });

        Channel channel = bootstrap.connect(new InetSocketAddress(8000)).sync().channel();
        User user = new User(1, "sunshuai");

        //user ---> ObjectEncoder user java序列化 二级制 ---> 服务端
        ObjectMapper objectMapper = new ObjectMapper();
        String userJSON = objectMapper.writer().writeValueAsString(user);

        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        buffer.writeCharSequence(userJSON, Charset.defaultCharset());

        channel.writeAndFlush(buffer);

    }
}