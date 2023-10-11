package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //保存方法
    @RequestMapping("save")
    public void save(User user){
        userService.save(user);
    }

    //查询所有
    @RequestMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
}
