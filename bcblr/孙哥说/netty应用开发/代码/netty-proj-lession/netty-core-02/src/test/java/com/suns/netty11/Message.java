package com.suns.netty11;

import java.io.Serializable;

//DTO
//数据传输对象
// client server都会使用 ，maven 独立的个jar
public class Message implements Serializable {
    private String username;
    private String password;

    public Message(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Message() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Message{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
