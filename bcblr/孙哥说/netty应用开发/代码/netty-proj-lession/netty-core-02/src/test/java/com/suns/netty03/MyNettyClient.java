package com.suns.netty03;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class MyNettyClient {
    private static final Logger log2 = LoggerFactory.getLogger(MyNettyClient.class);
    private static final Logger log1 = LoggerFactory.getLogger(MyNettyClient.class);
    private static final Logger log = LoggerFactory.getLogger(MyNettyClient.class);

    public static void main(String[] args) throws InterruptedException {
        log.debug("myNettyClientStarter------");

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringEncoder());
            }
        });

        //异步 阻塞方式进行 与服务器端连接
        ChannelFuture future = bootstrap.connect(new InetSocketAddress(8000));
        //future.sync();

        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                log1.debug(" add Listerner .....");
                Channel channel = future.channel();
                channel.writeAndFlush("hello suns");
            }
        });

        System.out.println("----------------------------------");

    }
}
/*
   1.  异步也是多线程编程..
   2.  异步编程 和 多线程编程 应用过程区别。
 */





