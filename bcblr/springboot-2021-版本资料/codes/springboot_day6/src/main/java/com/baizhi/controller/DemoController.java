package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("demo")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping("demo")
    public String  demo(){
        log.debug("demo ok!!!");
        return "demo";//modelAndView 对象返回  view视图  /demo.jsp
    }
}
