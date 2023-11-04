package com.suns.netty.domain;

import io.netty.channel.Channel;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/*
   存储的结构 从设计角度 全局唯一 map
   SesssionManager
 */
@Data
public class Session {

    private static final Map<String, Channel> usernameChannelMap = new HashMap<>();
    private static final Map<Channel, String> channelUserNameMap = new HashMap<>();


    /*
      方法的五要素 ：修饰符 返回值 方法名（参数表）异常
      channel username对应关系 存储 存储位置
      1. 多个用户的信息 多个channel 多个数据
      2. key value map

     */
    public void bind(Channel channel, String username) {
        usernameChannelMap.put(username, channel);
        channelUserNameMap.put(channel, username);
    }

    public void unbind(Channel channel) {
        String username = channelUserNameMap.remove(channel);
        if (username != null) {
            usernameChannelMap.remove(username);
        }
    }

    public Channel getChannel(String username) {
        return usernameChannelMap.get(username);
    }


}
