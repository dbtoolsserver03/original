package com.baizhiedu.factory;

import com.baizhiedu.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.login("suns", "111111");
        userService.register(new User());
    }
}
