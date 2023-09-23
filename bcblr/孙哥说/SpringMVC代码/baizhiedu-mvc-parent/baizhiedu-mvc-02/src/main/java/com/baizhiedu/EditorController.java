package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/editor")
public class EditorController {

    @RequestMapping("/editor2")
    public String editor2(String name, Date birthday) {
        System.out.println("name = " + name);
        System.out.println("birthday = " + birthday);
        return "param1";
    }

    @RequestMapping("/editor1")
    public String editor1(String name, Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "param1";
    }
}
