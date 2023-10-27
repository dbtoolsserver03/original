package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    private User user;

    @Autowired
    private UserService userService;

    @Autowired
    private Calendar calendar;

    @Autowired
    private Calendar calendar1;

    @GetMapping("/hello")
    public String hello(){
        System.out.println(" hello spring boot !!!");
        System.out.println(user);
        userService.save("小陈");
        System.out.println(calendar.getTime());
        System.out.println(calendar);
        System.out.println(calendar1);
        System.out.println(calendar == calendar1);
        return "hello springboot !!!";
    }
}
