package com.suns.netty.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Group {
    private String groupName;

    //用户的 用户名
    private Set<String> members;

    public Group(String groupName, Set<String> members) {
        this.groupName = groupName;
        this.members = members;
    }
}
