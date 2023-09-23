package com.concat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String toIndex(){
        return "concat/login";
    }

    @GetMapping("/toRegister")
    public String toRegister(){
        return "/concat/regist";
    }

    @GetMapping("/toSave")
    public String toSave(){
        return "/concat/addEmp";
    }

}
