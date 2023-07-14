package com.blr.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        String hello = "hello resource service";
        System.out.println(hello);
        return hello;
    }
}
