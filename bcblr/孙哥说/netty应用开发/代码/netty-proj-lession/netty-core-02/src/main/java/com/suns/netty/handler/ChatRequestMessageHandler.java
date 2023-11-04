package com.suns.netty.handler;

import com.suns.netty.domain.Session;
import com.suns.netty.message.ChatRequestMessage;
import com.suns.netty.message.ChatResponseMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class ChatRequestMessageHandler extends SimpleChannelInboundHandler<ChatRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ChatRequestMessage msg) throws Exception {
        String toUserName = msg.getTo();
        String content = msg.getContent();
        Session session = new Session();
        Channel channel = session.getChannel(toUserName);
        if (channel != null) {
            channel.writeAndFlush(new ChatResponseMessage("200", "chat ok", msg.getFrom(), content));
            ctx.writeAndFlush(new ChatResponseMessage("200", "send is OK"));
        } else {
            ctx.writeAndFlush(new ChatResponseMessage("500", "error"));
        }

    }
}
