package com.baizhiedu;

import com.baizhiedu.basic.BeanFactory;
import com.baizhiedu.basic.Person;
import com.baizhiedu.basic.User;
import com.baizhiedu.basic.UserService;
import com.baizhiedu.basic.constructer.Customer;
import com.baizhiedu.beanpost.Categroy;
import com.baizhiedu.factorybean.ConnectionFactoryBean;
import com.baizhiedu.life.Product;
import com.baizhiedu.scope.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestSpring {
    
    /**
     *  用于测试:工厂类进行解耦合的操作
     */
    @Test
    public void test1() {
        //UserServiceImplNew

        //UserServcice userService = new UserServiceImplNew()
//        UserService userService = new UserServiceImpl();


        UserService userService = (UserService) BeanFactory.getBean("userService");

        userService.login("name", "suns");


        User user = new User("suns", "123456");
        userService.register(user);


    }


    /**
     * 用于测试:
     */
    @Test
    public void test2() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println("person = " + person);
    }


    /**
     *  用于测试:用于测试Spring的第一个程序
     */
    @Test
    public void test3() {
         //1 获得Spring的工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //2 通过工厂类 获得 对象
        Person person = (Person) ctx.getBean("person");

        System.out.println("person = " + person);
    }

    /**
     *  用于测试:Spring工厂提供的其他方法
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        /*Person person = ctx.getBean("person", Person.class);
        System.out.println("person = " + person);
        */

        //当前Spring的配置文件中 只能有一个<bean class是Person类型
        /*Person person = ctx.getBean(Person.class);
          System.out.println("person = " + person);
        */

        //获取的是 Spring工厂配置文件中所有bean标签的id值  person person1
        /*String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        */

        //根据类型获得Spring配置文件中对应的id值
        /*String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String id : beanNamesForType) {
            System.out.println("id = " + id);
        }
        */

        //用于判断是否存在指定id值得bean,不能判断name值
        if (ctx.containsBeanDefinition("person")) {
            System.out.println("true = " + true);
        }else{
            System.out.println("false = " + false);
        }


        //用于判断是否存在指定id值得bean,也可以判断name值
        if (ctx.containsBean("p")) {
            System.out.println("true = " + true);
        }else{
            System.out.println("false = " + false);
        }


    }
    
   /**
    *  用于测试:spring的配置文件
    */
   @Test
   public void test5() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       /*Person person = ctx.getBean(Person.class);
       System.out.println("person = " + person);
       */

       String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
       for (String beanDefinitionName : beanDefinitionNames) {
           System.out.println("beanDefinitionName = " + beanDefinitionName);
       }
   }

   /**
    *  用于测试:用于测试name属性
    */
   @Test
   public void test6() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       Person p = (Person) ctx.getBean("person");
       System.out.println("p = " + p);
   }


   /**
    *  用于测试:用于测试注入
    */
   @Test
   public void test7() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       Person person = (Person) ctx.getBean("person");

       /*person.setId(1);
       person.setName("suns");*/

       System.out.println("person = " + person);


   }

   /**
    *  用于测试:通过spring的配置文件进行赋值（注入）
    */
   @Test
   public void test8() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       Person person = (Person) ctx.getBean("person");

       System.out.println("person = " + person);
   }

   /**
    *  用于测试:JDK类型成员变量的赋值
    */
   @Test
   public void test9() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       Person person = (Person) ctx.getBean("person");
       String[] emails = person.getEmails();
       for (String email : emails) {
           System.out.println("email = " + email);
       }
       System.out.println("--------------------------------------------------");
       Set<String> tels = person.getTels();
       for (String tel : tels) {
           System.out.println("tel = " + tel);
       }
       System.out.println("-----------------------------------------------------");
       List<String> addresses = person.getAddresses();
       for (String address : addresses) {
           System.out.println("address = " + address);
       }
       System.out.println("--------------------------------------------------");

       Map<String, String> qqs = person.getQqs();
       Set<String> keys = qqs.keySet();
       for (String key : keys) {
           System.out.println("key = " + key + " value is " + qqs.get(key));
       }
       System.out.println("-----------------------------------------------");
       Properties p = person.getP();
       System.out.println("key is key1"+ " values is "+p.getProperty("key1"));
       System.out.println("key is key2"+ " values is "+p.getProperty("key2"));
   }

   /**
    *  用于测试:用户自定义类型成员变量的赋值
    */
   @Test
   public void test10() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       UserService userService = (UserService) ctx.getBean("userService");

       userService.register(new User("suns", "123456"));
       userService.login("xiaohei", "999999");
   }
   /**
    *  用于测试:用于测试构造注入
    */
   @Test
   public void test11() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       Customer customer = (Customer) ctx.getBean("customer");
       System.out.println("customer = " + customer);
   }
   
   /**
    *  用于测试:用于测试FactoryBean接口 
    */
   @Test
   public void test12() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       Connection conn = (Connection) ctx.getBean("conn");
       Connection conn2 = (Connection) ctx.getBean("conn");

       System.out.println("conn = " + conn);
       System.out.println("conn = " + conn2);
   }

    /**
     *  用于测试:用于测试FactoryBean接口
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ConnectionFactoryBean conn = (ConnectionFactoryBean) ctx.getBean("&conn");

        System.out.println("conn = " + conn);
    }


    /**
     *  用于测试:用于测试实例工厂
     */
    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }

    /**
     *  用于测试:简单对象的创建次数
     */
    @Test
    public void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account1 = (Account) ctx.getBean("account");
        Account account2 = (Account) ctx.getBean("account");

        System.out.println("account = " + account1);
        System.out.println("account2 = " + account2);
    }

    /**
     *  用于测试:生命周期
     */
    @Test
    public void test16() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = (Product) ctx.getBean("product");
        ctx.close();
    }

   /**
    *  用于测试:配置文件参数化
    */
   @Test
   public void test17() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
       Connection conn = (Connection) ctx.getBean("conn");
       System.out.println("conn = " + conn);
   }

   /**
    *  用于测试:用于测试自定义类型转换器
    */
   @Test
   public void test18() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
       com.baizhiedu.converter.Person person = (com.baizhiedu.converter.Person) ctx.getBean("person");
       System.out.println("birthday = " + person.getBirthday());
   }


    /**
     *  用于测试:BeanPostProcessor
     */
    @Test
    public void test19() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext3.xml");
        Categroy c = (Categroy) ctx.getBean("c");

        System.out.println("name = "+c.getName());
    }


































}
