package com.boot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Address {

    private Long id;

    private Date addTime;

    private String address;

}
