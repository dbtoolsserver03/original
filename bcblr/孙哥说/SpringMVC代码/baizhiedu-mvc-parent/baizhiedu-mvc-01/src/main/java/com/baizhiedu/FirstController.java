package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@Scope("singleton")
//@Scope("prototype")
public class FirstController {

    public FirstController() {
        System.out.println("FirstController.FirstController");
    }

    //@RequestMapping("/first")
    //@RequestMapping("first")
    @RequestMapping(value = {"/first","/third"})
    public String first(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FirstController.first");
        return "/result.jsp";
    }

    // http://localhost:8989/basic/suns/second
    @RequestMapping(value="suns/second")
    public String second(HttpServletRequest request,HttpServletResponse response){
        System.out.println("FirstController.second");
        return "/result.jsp";
    }

}
