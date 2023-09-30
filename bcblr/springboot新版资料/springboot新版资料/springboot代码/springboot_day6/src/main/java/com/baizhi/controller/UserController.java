package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    //声明日志对象
    //private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;


    @ResponseBody
    @GetMapping("/delete")
    public String delete(String id){
        log.info("info信息~~ id: "+id);
        log.debug("debug信息~~ id:"+id);
        return id;
    }

    @GetMapping("/ok")
    @ResponseBody
    public String save(){
        System.out.println("这是保存方法");
        return"ok";
    }


    //findAll
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "showAll";
    }


    //save
    @GetMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/user/findAll";
    }
}
