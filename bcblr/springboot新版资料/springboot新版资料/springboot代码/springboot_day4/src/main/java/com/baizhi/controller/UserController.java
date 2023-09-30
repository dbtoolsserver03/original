package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {


    @GetMapping("findAll")
    public String findAll(HttpServletRequest request, Model model){
        System.out.println("查询所有");
        model.addAttribute("name","xiaochen");
        List<User> users = Arrays.asList(new User("21", "陈晨", 23, new Date()),new User("22", "小陈", 23, new Date()));
        model.addAttribute("users", users);
        return "back/index";//逻辑名  前缀+逻辑名+后缀 = /back/index.jsp
    }
}
