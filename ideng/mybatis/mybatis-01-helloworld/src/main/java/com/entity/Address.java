package com.entity;

import lombok.Data;

/**
 * 地址 实体类
 *
 * @author zqd
 *
 * @date 2022-05-09 01:05:24
 */
@Data
public class Address{

    /** 主键ID **/
    private Long id;

    /** 入库时间 **/
    private java.util.Date addTime;

    /** 地址 **/
    private String address;

}

