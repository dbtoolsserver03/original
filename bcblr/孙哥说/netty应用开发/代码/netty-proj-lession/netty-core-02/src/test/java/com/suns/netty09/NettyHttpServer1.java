package com.suns.netty09;

import com.suns.netty08.MyNettyServer1;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;

public class NettyHttpServer1 {

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
                //与http协议相关的编解码器
                // 接受请求的时候，解码 http协议转换httpObject
                // 提供相应的时候，编码 httpObject转换成http协议响应给client
                pipeline.addLast(new HttpServerCodec());
               /* pipeline.addLast(new HttpRequestDecoder());
                pipeline.addLast(new HttpResponseEncoder());*/
                //SimpleChannelInboundHandler作用 关注的消息类型
                pipeline.addLast(new SimpleChannelInboundHandler<HttpRequest>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, HttpRequest msg) throws Exception {
                        //HttpRequest request = (HttpRequest) msg;
                        //请求头
                        HttpHeaders headers = msg.headers();
                        //请求行
                        String uri = msg.uri();
                        HttpVersion httpVersion = msg.protocolVersion();
                        HttpMethod method = msg.method();

                        log.debug("uri {} " + uri);

                        //状态行
                        DefaultFullHttpResponse response = new DefaultFullHttpResponse(httpVersion, HttpResponseStatus.OK);

                        byte[] bytes = "<h1>Hello Suns</h1>".getBytes();

                        //response.setHeader(Content-Length,10);
                        response.headers().set(CONTENT_LENGTH, bytes.length);
                        response.content().writeBytes(bytes);

                        ctx.writeAndFlush(response);
                    }
                });

            }
        });
        //client浏览器 http://localhost:8000/xxx
        serverBootstrap.bind(8000);
    }
}

