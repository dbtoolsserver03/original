package com.suns.netty.handler;

import com.suns.netty.domain.Group;
import com.suns.netty.domain.GroupSession;
import com.suns.netty.message.GroupCreateRequestMessage;
import com.suns.netty.message.GroupCreateResponseMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

@ChannelHandler.Sharable
public class GroupCreateMessageHandler extends SimpleChannelInboundHandler<GroupCreateRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupCreateRequestMessage msg) throws Exception {
        GroupSession groupSession = new GroupSession();
        Group group = groupSession.createGroup(msg.getGroupName(), msg.getMembers());
        if (group == null) {
            //如果成功 给所有的组员发消息 告知 已经加入了该组
            List<Channel> membersChannel = groupSession.getMembersChannel(msg.getGroupName());
            for (Channel channel : membersChannel) {
                channel.writeAndFlush(new GroupCreateResponseMessage("200", "you add " + msg.getGroupName()));
            }
        } else {
            //这个组已经存在了
            ctx.writeAndFlush(new GroupCreateResponseMessage("500", "group create error or exits"));
        }
    }
}
