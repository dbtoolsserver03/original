package com.suns.netty02;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class MyNettyClient {

    private static final Logger log = LoggerFactory.getLogger(MyNettyClient.class);

    public static void main(String[] args) throws InterruptedException {
        log.debug("myNettyClientStarter------");
        //1 统一编程模型
          /*
              编程模型 --->  编程一个套路 一模版
              统一编程模型 ---> 简化开发过程 ---> Spring(编程模式统一） Redis MQ xx  xxx
           */
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringEncoder());
            }
        });
        //connect使用了一个新的线程，用于连接...
        ChannelFuture future = bootstrap.connect(new InetSocketAddress(8000));
        //为什么要做同步，阻塞。
        future.sync();
        Channel channel = future.channel();
        channel.writeAndFlush("hello suns");
        //System.out.println("------------------------------");
    }
}
