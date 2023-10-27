package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private Date addTime;

    private String userName;

    private String password;

}

