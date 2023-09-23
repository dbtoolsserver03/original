package com.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String toIndex(){
        return "car/login";
    }

    @GetMapping("/toRegister")
    public String toRegister(){
        return "/car/regist";
    }

    @GetMapping("/toSave")
    public String toSave(){
        return "/car/addEmp";
    }

}
