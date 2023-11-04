package com.suns.netty13;

import io.netty.channel.*;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MyWebScoketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger log = LoggerFactory.getLogger(MyWebScoketHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // log.debug("接受到client的数据为 {} ", msg.text());

        Channel channel = ctx.channel();
      /*  Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                channel.writeAndFlush(new TextWebSocketFrame("xiaohei"));
            }
        }, 2000,2000);*/

        EventLoopGroup eventLoopGroup = new DefaultEventLoopGroup(2);
        EventLoop next = eventLoopGroup.next();

        next.schedule(() -> {
            channel.writeAndFlush(new TextWebSocketFrame("xiaohei"));
        }, 2, TimeUnit.SECONDS);

    }
}
