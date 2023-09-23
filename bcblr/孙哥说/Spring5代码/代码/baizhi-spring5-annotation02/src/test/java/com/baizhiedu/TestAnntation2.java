package com.baizhiedu;

import com.baizhiedu.mybatis.MyBatisAutoConfiguration;
import com.baizhiedu.mybatis.User;
import com.baizhiedu.mybatis.UserDAO;
import com.baizhiedu.mybatis.UserService;
import com.baizhiedu.yml.Account;
import com.baizhiedu.yml.YmlAutoConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestAnntation2 {

    /**
     *  用于测试:Spring + Mybatis注解的整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyBatisAutoConfiguration.class);
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

        User user = new User();
        user.setName("annotation1");
        user.setPassword("1234567");

        userDAO.save(user);
    }

    /**
     *  用于测试:注解版 事务开发
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhiedu.mybatis");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");

        User user = new User();
        user.setName("txAnnotation");
        user.setPassword("123456");

        userServiceImpl.register(user);
    }


    /**
     *  用于测试:YML
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(YmlAutoConfiguration.class);
        Account account = (Account) ctx.getBean("account");
        /*System.out.println("account.getName() = " + account.getName());
        System.out.println("account.getPassword() = " + account.getPassword());*/

        List<String> list = account.getList();
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }











}
