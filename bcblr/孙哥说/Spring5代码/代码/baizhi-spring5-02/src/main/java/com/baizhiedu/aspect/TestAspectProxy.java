package com.baizhiedu.aspect;

import com.baizhiedu.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectProxy {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        //userService.login("suns", "123456");

        userService.register(new User());
    }
}
