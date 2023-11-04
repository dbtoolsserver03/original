package com.suns.netty13;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyNettyServer1 {

    private static final Logger log = LoggerFactory.getLogger(MyNettyServer1.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.group(new NioEventLoopGroup());
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new LoggingHandler());
                // WebSocket在Http协议之上的，所以要想处理WS，也是要处理Http
                pipeline.addLast(new HttpServerCodec());
                //FullRequest
                pipeline.addLast(new HttpObjectAggregator(1024));
                //Netty处理WebSocket的handler
                //ws://xxxx:8080/suns
                //TextWebSocketFrame
                pipeline.addLast(new WebSocketServerProtocolHandler("/suns"));
                pipeline.addLast(new MyWebScoketHandler());

            }
        });
        serverBootstrap.bind(8000);
    }
}
