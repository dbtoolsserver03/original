package com.baizhi.entity;

import java.util.Date;

public class User {

    private String id;
    private String username;
    private String password;
    private Date uptime;
    private Date lastlogintime;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uptime=" + uptime +
                ", lastlogintime=" + lastlogintime +
                ", role='" + role + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
    }

    public User(String id, String username, String password, Date uptime, Date lastlogintime, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.uptime = uptime;
        this.lastlogintime = lastlogintime;
        this.role = role;
    }
}
