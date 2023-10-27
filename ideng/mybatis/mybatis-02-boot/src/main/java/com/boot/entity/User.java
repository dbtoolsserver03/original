package com.boot.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户
 */
@Data
public class User {
    /** 主键ID */
    private Long id;

    /** 入库时间 */
    private Date addTime;

    /** 用户名 */
    private String userName;

    /** 密码 */
    private String password;

    /** 年龄 */
    private Integer age;

    /** 性别:0 女 1 男 */
    private Integer sex;

    /** 地址 */
    private Address address;

    /** 菜单 */
    private List<Menu> menus;


}

