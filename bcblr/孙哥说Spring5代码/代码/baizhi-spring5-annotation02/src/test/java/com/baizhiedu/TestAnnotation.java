package com.baizhiedu;

import com.baizhiedu.bean.Customer;
import com.baizhiedu.bean.User;
import com.baizhiedu.four.Account;
import com.baizhiedu.four.AppConfig10;
import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class TestAnnotation {
    
    /**
     *  用于测试:配置Bean
     */
    @Test
    public void test1() {
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhiedu");
    }
    
    /**
     *  用于测试:@Bean注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        /*User user = (User) ctx.getBean("user");

        System.out.println("user = " + user);
        */

        /*Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);*/

        Connection conn1 = (Connection) ctx.getBean("conn1");
        System.out.println("conn1 = " + conn1);
    }


    /**
     *  用于测试:对象的创建次数
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User u = (User) ctx.getBean("u");
        User u1 = (User) ctx.getBean("u");

        System.out.println("u1 = " + u1);
        System.out.println(u);
    }
    
    /**
     *  用于测试:@Bean注解注入
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register();
    }
    
    /**
     *  用于测试:@Bean JDK类型的注入
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer.getId());
        System.out.println("customer = " + customer.getName());

    }

    /**
     *  用于测试:@ComponentScan 基本使用
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }


    /**
     *  用于测试:配置的覆盖
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer.getId() = " + customer.getId());
        System.out.println("customer.getName() = " + customer.getName());

        //new ClassPathXmlApplicationContext("");

    }

    /**
     *  用于测试:解耦合
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class,AppConfig5.class);
        //ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhiedu");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

        userDAO.save();
    }


    /**
     *  用于测试:多配置Bean的整合
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.baizhiedu.config");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);

    }


    @Test
    public void test10() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhiedu.config.AppConfig1.class);
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");
        /*System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);

        */

        userService.register();
    }



    /**
     *  用于测试:@Component与配置Bean的整合
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhiedu.config.AppConfig3.class);
        UserService userService = (UserService) ctx.getBean("userService");
        /*UserDAO userDAOImpl = (UserDAO) ctx.getBean("userDAOImpl");
        System.out.println("userService = " + userService);
        System.out.println("userDAOImpl = " + userDAOImpl);
*/
        userService.register();
    }


    @Test
    public void test12() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.baizhiedu.config.AppConfig4.class);
        UserService userService = (UserService) ctx.getBean("userService");
        /*UserDAO userDAOImpl = (UserDAO) ctx.getBean("userDAO");
        System.out.println("userService = " + userService);
        System.out.println("userDAOImpl = " + userDAOImpl);*/

        userService.register();

    }
    @Test
    public void test13() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User u = (User) ctx.getBean("u");

    }

    /**
     *  用于测试:四维一体开发
     */
    @Test
    public void test14() {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig10.class);
        Account account = (Account) ctx.getBean("account");
        System.out.println("account.getId() = " + account.getId());
        System.out.println("account.getName() = " + account.getName());

    }








}




































