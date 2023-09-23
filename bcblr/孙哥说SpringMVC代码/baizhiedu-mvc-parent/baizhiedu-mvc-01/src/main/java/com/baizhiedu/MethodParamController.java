package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/methodParam")
public class MethodParamController {

    @RequestMapping("/m1")
    public String m1(HttpSession session) {
        System.out.println("session = " + session);
        return "/result.jsp";
    }

    @RequestMapping("/m2")
    public String m2() {
        System.out.println("MethodParamController.m2");
        return "/result.jsp";
    }
}
