package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hello")
public class HelloController {


    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("name","<a href=''>张三</a>");
        model.addAttribute("username","小陈");
        model.addAttribute("user",new User("21","xiaochen",23,new Date()));
        System.out.println("测试与 thymeleaf 的集成");
        model.addAttribute("users", Arrays.asList(new User("21","xiaohei",23,new Date()),new User("21","xiaohei",23,new Date())));
        return "index";
    }










    @Value("${name}")
    private String name;

    @Value("${server.port}")
    private int port;

    @Value("${bir}")
    private Date bir;

    @Value("${strs}")
    private String[] strs;

    @Value("${qqs}")
    private List<String> qqs;

    @Value("#{${maps}}")
    private Map<String,String> maps;

    @Autowired
    private User user;

    @GetMapping("hello1")
    public String hello1(){
        System.out.println("hello springboot");
        System.out.println("name = " + name);
        System.out.println("port = " + port);
        System.out.println("bir = " + bir);
        for (String str : strs) {
            System.out.println(str);
        }
        qqs.forEach(qq-> System.out.println("qq = " + qq));
        maps.forEach((k,v)-> System.out.println("k=" + k+"   v="+v));
        System.out.println("user = " + user);
        return "hello springboot !!!";
    }
}
