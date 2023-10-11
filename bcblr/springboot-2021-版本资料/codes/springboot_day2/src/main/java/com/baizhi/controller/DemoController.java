package com.baizhi.controller;

import com.baizhi.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;


/**
 * 用来测试对象创建
 */
@RestController
public class DemoController {

    @Autowired
    @Qualifier(value = "demoService") //作用:用来修改autowired默认不在根据类型注入 修改为根据名称注入
    private DemoService demoService;

    @Autowired
    @Qualifier("calendar")
    private Calendar calendar;

    @RequestMapping("demo")
    public String demo(){
        System.out.println("demo ok");
        demoService.demo();

        System.out.println("工厂中获取日历对象,当前时间为: "+calendar.getTime());
        return  "demo ok";
    }
}
