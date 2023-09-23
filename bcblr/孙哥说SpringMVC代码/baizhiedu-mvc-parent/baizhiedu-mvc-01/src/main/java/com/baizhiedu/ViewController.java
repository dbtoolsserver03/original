package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/m1")
    public String m1() {
        System.out.println("ViewController.m1");
        return "result";
    }
}
