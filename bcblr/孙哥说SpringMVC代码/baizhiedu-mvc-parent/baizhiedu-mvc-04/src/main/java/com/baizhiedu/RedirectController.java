package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @RequestMapping("/redirect1")
    public String redirect1() {
        System.out.println("RedirectController.redirect1");
        return "redirect:/redirect/redirect2";
    }

    @RequestMapping("/redirect2")
    public String redirect2() {
        System.out.println("RedirectController.redirect2");
        return "result";
    }
}
