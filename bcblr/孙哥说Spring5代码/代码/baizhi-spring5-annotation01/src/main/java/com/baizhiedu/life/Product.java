package com.baizhiedu.life;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Product {

    @PostConstruct
    public void myInit() {
        System.out.println("Product.myInit");
    }

    @PreDestroy
    public void myDestory() {
        System.out.println("Product.myDestory");
    }
}
