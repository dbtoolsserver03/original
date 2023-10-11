package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试jsp模板集成
 */
@Controller
public class JspController {


    @RequestMapping("jsp")
    public String jsp(){
        System.out.println("jsp ok");
        return "index";
    }

}
