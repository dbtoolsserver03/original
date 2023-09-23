package com.baizhiedu;

import com.baizhiedu.aop.AppConfig;
import com.baizhiedu.aop.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation1 {
    /**
     *  用于测试:AOP
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");

        userServiceImpl.register();
        userServiceImpl.login();
    }
}
