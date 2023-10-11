package com.baizhi.controller;

import com.baizhi.exception.UserNameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class DemoController {



    @RequestMapping("demo")
    public String demo(){
        System.out.println("demo ok ...");
        int n = 1/0;//报错: 除零异常
        return "hello";
    }



    @RequestMapping("login")
    public String login(String username,String password){
        System.out.println("login ...");
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        if("xiaochen".equals(username) && "123".equals(password)){
            return "hello";//返回成功页面
        }else{
            throw new UserNameNotFoundException("用户名不正确!!");
        }
    }


}
