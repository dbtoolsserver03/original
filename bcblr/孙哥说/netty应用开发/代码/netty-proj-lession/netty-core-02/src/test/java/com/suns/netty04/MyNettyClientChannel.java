package com.suns.netty04;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class MyNettyClientChannel {
    private static final Logger log = LoggerFactory.getLogger(MyNettyClientChannel.class);

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

        ChannelFuture future = bootstrap.connect(new InetSocketAddress(8000));
        future.sync();

        Channel channel = future.channel();
        //channel.writeAndFlush("xiaohei").sync();
        channel.writeAndFlush("xiaohei");
        //System.out.println("-----------------------------");


        ChannelFuture close = channel.close();//异步化操作 启动一个新的线程
        //其他资源的释放，其他事，close()方法执行完之后，运行后面这些代码
        //main主线程完成
        //close.sync();

        close.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                log.debug("channel.close()执行完后，操作后续的一些工作...");//不行
            }
        });

        //优雅的关闭。
        //结束当前的client
        //所有的线程都结束处理之后，才会关闭client
        //32  1 channel操作 31
        //linux  kill -9
        eventLoopGroup.shutdownGracefully();


    }
}