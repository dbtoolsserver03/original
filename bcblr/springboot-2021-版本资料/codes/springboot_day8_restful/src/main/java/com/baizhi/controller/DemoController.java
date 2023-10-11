package com.baizhi.controller;

import com.baizhi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller //代表这个类是一个控制器
@RequestMapping("demo")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    //查询一个  传统wbe开发: 不是restful风格  就是用 @RequestMapping映射请求路径:  支持任何一个请求请求这个路径

    @RequestMapping("findUserById") //GET POST DELETE PUT PATCH

    public String findUserById(Integer id){
        log.info("查询用户id为: {}",id);
        User user = new User(21, "xiaochen", 2300.23, new Date());
        //存储到作用域
        return "showOne";
    }

    //查询所有
    @RequestMapping("findAll")
    public String findAll(){
        log.info("查询所有");
        List<User> userList  = new ArrayList<User>();
        userList.add(new User(21,"xiaochen",2300.23,new Date()));
        //存储到作用域
        return "showAll";
    }


    //保存
    @RequestMapping("saveUser")
    public String save(User user){
        log.info("user: {}",user);
        return "redirect:/user/findAll";
    }

    //修改
    @RequestMapping("updateUser")
    public String update(User user){
        log.info("user: {}",user);
        return "redirect:/user/findAll";
    }

    //删除
    @RequestMapping("deleteUser")
    public String delete(Integer id){
        log.info("删除用户id为: {}",id);
        return  "redirect:/user/findAll";
    }


}
