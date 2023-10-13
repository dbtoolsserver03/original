package com.ph.share.hystrix.user.entity;

public class User {
    // 用户 id
    private Long id;
    // 用户名
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
