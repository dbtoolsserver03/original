package com.baizhiedu;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.entity.User;
import com.baizhiedu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatisSpring {
    /**
     *  用于测试:Spring与Mybatis的整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");


        User user = new User();
        user.setName("xiaojr");
        user.setPassword("999999");


        userDAO.save(user);
    }

    /**
     *  用于测试:Spring的事务处理
     */
    @Test
    public void test2() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");


        User user = new User();
        user.setName("xiaowb3");
        user.setPassword("989898");
        userService.register(user);

    }

    /**
     *  用于测试:Spring基于标签事务处理
     */
    @Test
    public void test3() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext-tx.xml");
        UserService userService = (UserService) ctx.getBean("userService");


        User user = new User();
        user.setName("xiaowb4");
        user.setPassword("989898");
        userService.register(user);

    }
}
