package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forward")
public class ForwardController {

    @RequestMapping("/forward1")
    public String forward1() {
        System.out.println("ForwardController.forward1");
        return "forward:/forward/forward2";
    }

    @RequestMapping("/forward2")
    public String forward2() {
        System.out.println("ForwardController.forward2");
        return "result";
    }
}
