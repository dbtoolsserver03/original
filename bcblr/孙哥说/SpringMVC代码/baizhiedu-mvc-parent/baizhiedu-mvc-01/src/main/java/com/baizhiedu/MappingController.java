package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {

    @RequestMapping(value = "/m2", method = {RequestMethod.DELETE})
    @ResponseBody
    public String m2() {
        System.out.println("MappingController.m2");
        return "delete is ok";
    }

    @RequestMapping(value = "/m1", method = {RequestMethod.POST, RequestMethod.GET})
    public String m1() {
        System.out.println("MappingController.m1");
        return "/result.jsp";
    }
}
