package com.suns.netty.domain;

import io.netty.channel.Channel;

import java.util.*;

public class GroupSession {
    //1 存储聊天室的信息
    // key string 聊天室的名字
    private static final Map<String, Group> groupMap = new HashMap<>();

    public Group createGroup(String name, Set<String> members) {
        Group group = new Group(name, members);
        /*
           也是向map中 添加key value

           如果添加 key value 不存在 返回null
         */
        return groupMap.putIfAbsent(name, group);
    }

    //获取聊天室的成员

    public Set<String> getMembers(String name) {
        return groupMap.get(name).getMembers();
    }

    //获取聊天室成员的channel
    // 首先获取member的用户名 Session找他对应的Channel
    public List<Channel> getMembersChannel(String name) {
        List<Channel> retList = new ArrayList<>();
        Set<String> members = getMembers(name);
        for (String member : members) {
            Session session = new Session();
            Channel channel = session.getChannel(member);
            retList.add(channel);
        }
        return retList;
    }


}
