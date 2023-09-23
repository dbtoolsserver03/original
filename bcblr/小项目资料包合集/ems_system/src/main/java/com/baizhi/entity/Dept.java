package com.baizhi.entity;

import java.util.Date;

public class Dept {
    private String id;
    private String name;
    private Date uptime;
    private String numbers;




    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", uptime=" + uptime +
                ", numbers='" + numbers + '\'' +
                '}';
    }

    public Dept() {
    }

    public Dept(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Dept(String id, String name, Date uptime, String numbers) {
        this.id = id;
        this.name = name;
        this.uptime = uptime;
        this.numbers = numbers;
    }
}

