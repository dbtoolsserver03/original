package com.entity;

import lombok.Data;

import java.util.List;

/**
 * 用户 实体类
 *
 * @author zqd
 *
 * @date 2022-05-07 23:35:01
 */
@Data
public class User{

    /** 主键ID **/
    private Long id;

    /** 入库时间 **/
    private java.util.Date addTime;

    /** 用户名 **/
    private String userName;

    /** 密码 **/
    private String password;

    /** 年龄 **/
    private Integer age;

    /** 性别:0女 1男 **/
    private Integer sex;


    private Address address;

    private List<Goods> goods;

}

