package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //测试控制器  测试地址: http://localhost:端口号/项目名/请求路径
    //注意: springboot项目默认启动没有项目名 http://localhost:8080/hello
    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello springboot.....");
        return "hello springboot";
    }
}
