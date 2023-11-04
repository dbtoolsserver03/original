package com.suns.netty04;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class MyNettyServer {

    private static final Logger log1 = LoggerFactory.getLogger(MyNettyServer.class);
    private static final Logger log = LoggerFactory.getLogger(MyNettyServer.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.group(new NioEventLoopGroup());
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("handler1", new ChannelInboundHandlerAdapter() {
                    @Override
                    //ByteBuf
                    //自己开发了一个StringDecoder
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("handler1");
                        ByteBuf buf = (ByteBuf) msg;
                        String s = buf.toString(Charset.defaultCharset());
                        System.out.println(s);
                        //super.channelRead(ctx, s);
                        ctx.fireChannelRead(s);
                    }
                });

                pipeline.addLast("handler2", new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("handler2 ctx ... {} ", msg);
                        super.channelRead(ctx, msg);
                    }
                });
                pipeline.addLast("hadler4", new ChannelOutboundHandlerAdapter() {
                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                        log1.debug("handler4");
                        super.write(ctx, msg, promise);
                    }
                });
                pipeline.addLast("hadler5", new ChannelOutboundHandlerAdapter() {
                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                        log1.debug("handler5");
                        super.write(ctx, msg, promise);
                    }
                });
                pipeline.addLast("handler3", new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("handler3");
                        //super.channelRead(ctx, msg);
                        //ch.writeAndFlush("hello  suns");
                        ctx.writeAndFlush("hello xiaojr");
                    }
                });

                pipeline.addLast("hadler6", new ChannelOutboundHandlerAdapter() {
                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                        log1.debug("handler6");
                        super.write(ctx, msg, promise);
                    }
                });

            }
        });
        serverBootstrap.bind(8000);
    }
}
