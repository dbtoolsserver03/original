package com.entity;

import lombok.Data;

/**
 * 商品 实体类
 *
 * @author zqd
 *
 * @date 2022-05-09 01:26:54
 */
@Data
public class Goods{

    /** 主键ID **/
    private Long id;

    /** 入库时间 **/
    private java.util.Date addTime;

    /** 商品名称 **/
    private String goodsName;

    private Long userId;

}

