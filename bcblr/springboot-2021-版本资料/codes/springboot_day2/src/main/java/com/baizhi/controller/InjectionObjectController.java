package com.baizhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试对象注入
 */
@RestController
@ConfigurationProperties(prefix = "orders")
    //修饰范围: 用在类上  作用: 用来将指定前缀的属性 注入到当前对象中属性名一致属性中
    //注意: 使用这个注解为属性一次性赋值  必须为属性提供SET方法
public class InjectionObjectController {

    private Integer id;
    private String name;
    private Double price;


    @RequestMapping("injectObject")
    public String injectObject(){
        System.out.println("injectObject ok");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        return "injectObject ok";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
