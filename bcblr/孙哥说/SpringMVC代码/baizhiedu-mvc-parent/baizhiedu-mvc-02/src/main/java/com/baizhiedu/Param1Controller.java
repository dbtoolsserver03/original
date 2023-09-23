package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param1")
public class Param1Controller {

    @RequestMapping("/param6")
    public String param6(String name, @RequestParam(defaultValue = "0") int age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "param1";
    }

    @RequestMapping("/param5")
    public String param5(@RequestParam String name, @RequestParam(defaultValue = "123456") String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }

    @RequestMapping("/param4")
    public String param4(@RequestParam String name, @RequestParam(required = false) String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }

    @RequestMapping("/param3")
    public String param3(@RequestParam("id<") Integer id) {
        System.out.println("id = " + id);
        return "param1";
    }

    @RequestMapping("/param2")
    public String param2(@RequestParam User user) {
        System.out.println("user = " + user);
        return "param1";
    }

    @RequestMapping("/param1")
    public String param1(@RequestParam("n") String name, @RequestParam("p") String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }
}
