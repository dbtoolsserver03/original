package com.suns.netty08;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class MyNettyServer1 {

    private static final Logger log = LoggerFactory.getLogger(MyNettyServer1.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.group(new NioEventLoopGroup());
        //接受socket缓冲区大小 等同于 滑动窗口的初始值 65535
        //serverBootstrap.option(ChannelOption.SO_RCVBUF, 100);
        //netty创建ByteBuf时 执行大小 默认1024 child ScoketChannel相关
        serverBootstrap.childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(16, 16, 16));
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                //JsonObjectDecoder JSON解码 ---> json--java 错误认真
                // JSON解码 ---> ByteBuf
                // 解决JSON的封帧
                pipeline.addLast(new JsonObjectDecoder());
                //JSON解码器 干什么？
                pipeline.addLast(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        //User user = (User)msg;
                        //log.debug("{}",user);
                        ByteBuf byteBuf = (ByteBuf) msg;
                        String userJSON = byteBuf.toString(Charset.defaultCharset());
                        ObjectMapper objectMapper = new ObjectMapper();
                        User user = objectMapper.readValue(userJSON, User.class);

                        log.debug("{}", userJSON);
                        log.debug("user object is {} ", user);
                        super.channelRead(ctx, msg);
                    }
                });
                pipeline.addLast(new LoggingHandler());

            }
        });
        //
        serverBootstrap.bind(8000);
    }
}
