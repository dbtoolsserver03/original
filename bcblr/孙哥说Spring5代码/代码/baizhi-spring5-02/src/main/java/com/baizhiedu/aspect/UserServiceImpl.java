package com.baizhiedu.aspect;

import com.baizhiedu.Log;
import com.baizhiedu.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, ApplicationContextAware {
    private ApplicationContext ctx;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
              this.ctx = applicationContext;
    }

    @Log
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 + DAO ");
        //throw new RuntimeException("测试异常");

        //调用的是原始对象的login方法 ---> 核心功能
        /*
            设计目的：代理对象的login方法 --->  额外功能+核心功能
            ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
            UserService userService = (UserService) ctx.getBean("userService");
            userService.login();

            Spring工厂重量级资源 一个应用中 应该只创建一个工厂
         */

        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("suns", "123456");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
