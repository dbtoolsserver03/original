package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/param7")
    public String param7(UsersDTO usersDTO) {
        List<User> users = usersDTO.getUsers();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        return "param1";
    }

    @RequestMapping("/param6")
    public String param6(ArrayList<Integer> ids) {
        for (Integer id : ids) {
            System.out.println("id = " + id);
        }
        return "param1";
    }

    @RequestMapping("/param5")
    public String param5(int[] ids) {
        for (int id : ids) {
            System.out.println("id = " + id);
        }
        return "param1";
    }

    @RequestMapping("/param4")
    public String param4(String name, User user) {
        System.out.println("name = " + name);
        System.out.println("user = " + user);
        return "param1";
    }

    @RequestMapping("/param3")
    public String param3(String name, Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "param1";
    }

    @RequestMapping("/param2")
    public String param2(String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }

    @RequestMapping("/param1")
    public String param1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }
}
