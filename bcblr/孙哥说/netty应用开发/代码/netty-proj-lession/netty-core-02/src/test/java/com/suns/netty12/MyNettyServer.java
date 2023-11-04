package com.suns.netty12;

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
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //head  自定义1  自定义2  tail 5个
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new StringDecoder());
                pipeline.addLast(new ChannelInboundHandlerAdapter() {
                    @Override
                    /*
                       ChannelHandlerContext 就是Handler(ChannelHandler)上下文
                       1. 数据 ByteBuf
                       2. Handler运行流程
                       3. 负责数据的传递 ....
                     */
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("{}", ctx.hashCode());
                        //不建议使用
                        //ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
                        //建议使用
                        ctx.alloc().buffer();
                        super.channelRead(ctx, msg);
                    }
                });
                pipeline.addLast(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        log.debug("{}", ctx.hashCode());
                        super.channelRead(ctx, msg);
                    }
                });

                System.out.println("---");
            }
        });
        //
        serverBootstrap.bind(8000);
    }
}
