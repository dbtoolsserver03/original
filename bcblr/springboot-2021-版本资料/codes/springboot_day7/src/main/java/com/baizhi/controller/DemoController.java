package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("demo")
public class DemoController {


    //forward跳转:    request、model 作用域
    //redirect跳转:   session 作用域
    //传递单个数据  String Integer
    //传递对象类型  User
    //传递集合类型  List<User>
    //如何在页面中有条件展示数据   判断
    @RequestMapping("demo")
    public String demo(HttpServletRequest request, Model model, HttpSession session) {
        System.out.println("demo ok");
        //传递单个数据数据
        String name = "小陈";
        Integer age = 25;
        String content = "<a href='http://www.baidu.com'>百度一下</a>";
        request.setAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("content", content);

        //传递对象类型数据
        User user = new User(21, "小张", 2300.23, new Date());
        request.setAttribute("user", user);

        //传递集合类型数据
        List<User> users = Arrays.asList(new User(22, "小黄", 232.2, new Date()),
                                         new User(23, "小王", 232.2, new Date()),
                                         new User(24,"win7",232.2,new Date()));

        model.addAttribute("users",users);

        //向session作用域存储数据  session.key   application.key
        session.setAttribute("username","小二黑");

        return "demo";
    }
}
