package com.atguigu.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.boot.bean.Car;

import lombok.extern.slf4j.Slf4j;

//@ResponseBody
//@Controller





// JRebel
@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){

        log.info("请求进来了....");
        return "Hello, Spring Boot 2!"+"你好："+name;
    }

    @Autowired
    Car car;


    @RequestMapping("/car")
    public Car car(){
        return car;
    }



}
