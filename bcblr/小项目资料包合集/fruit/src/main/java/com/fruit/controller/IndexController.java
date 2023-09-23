package com.fruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String toIndex(){
        return "fruit/login";
    }

    @GetMapping("/toRegister")
    public String toRegister(){
        return "/fruit/regist";
    }

    @GetMapping("/toSave")
    public String toSave(){
        return "/fruit/addEmp";
    }

}
