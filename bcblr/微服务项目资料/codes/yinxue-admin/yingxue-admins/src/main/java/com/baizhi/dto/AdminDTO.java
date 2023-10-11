package com.baizhi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminDTO {

    //@JsonFormat //用来修改转换日期时间格式
    @JsonProperty("name")
    private String username;

    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AdminDTO() {
    }

    public AdminDTO(String username, String avatar) {
        this.username = username;
        this.avatar = avatar;
    }
}
