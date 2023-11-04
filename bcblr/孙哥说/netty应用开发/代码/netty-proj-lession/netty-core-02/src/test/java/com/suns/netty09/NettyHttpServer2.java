package com.suns.netty09;

import com.suns.netty08.MyNettyServer1;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyHttpServer2 {

    private static final Logger log = LoggerFactory.getLogger(MyNettyServer1.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.group(new NioEventLoopGroup());
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new LoggingHandler());
                //HttpServerCodec在进行解码操作时，把一个Http协议解码成了2个Message，分别HttpRequest HttpContent
                //在处理的过程中麻烦
                //1 SimpleChannelInboudHandler 进行了类型的限定
                //2 对HttpMessage进行聚合 FullHttpRequest
                pipeline.addLast(new HttpServerCodec());
                pipeline.addLast(new HttpObjectAggregator(1024));
                pipeline.addLast(new ChannelInboundHandlerAdapter(){
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        //FullHttpRequest 在一个类型中同时封装了HttpRequest,HttpContent
                        log.debug("{} ", msg);

                        DefaultFullHttpRequest request = (DefaultFullHttpRequest) msg;
                        request.headers();
                        request.content();

                        super.channelRead(ctx, msg);
                    }
                });



            }
        });
        //client浏览器 http://localhost:8000/xxx
        serverBootstrap.bind(8000);
    }
}

