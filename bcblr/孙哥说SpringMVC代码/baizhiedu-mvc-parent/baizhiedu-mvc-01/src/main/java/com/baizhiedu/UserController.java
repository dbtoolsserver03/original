package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/addUser")
    public String addUser() {
        System.out.println("UserController.addUser");
        return "/result.jsp";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser() {
        System.out.println("UserController.deleteUser");
        return "/result.jsp";
    }
}
