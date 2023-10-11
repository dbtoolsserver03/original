package com.baizhi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 修饰范围: 用在类上 只能用在入口类上 只能出现一次
// 作用: 标识这个类是一个springboot入口类  启动整个springboot项目总入口
// 总结: 1.pom文件引入依赖  2.resources生成application.yml 3.创建入口类加入@SpringBootApplication注解 在main中启动应用
@SpringBootApplication
public class SpringBootDay1Application {


    public static void main(String[] args) {
        //启动springboot应用 参数1: 指定入口类的类对象 .class  参数2: main函数参数
        SpringApplication.run(SpringBootDay1Application.class,args);
    }

}
// springboot =  springmvc(控制器controller) +  spring(工厂)

/**
 *  @SpringBootApplication:  注解
 *      组合注解: 就是由多个注解组合而成一个注解
 *      元注解 :  用来修饰注解的注解   @Target:指定注解作用范围   @Retention:指定注解什么时候有效
 *
 *   @SpringBootConfiguration:  这个注解就是用来自动配置spring springmvc(初始化 servlet ..)相关环境
 *   @EnableAutoConfiguration:  开启自动配置 自动配置核心注解  自动配置spring相关环境 自动与项目中 引入第三方技术自动配置其环境
 *                              mybatis-springboot、redis-springboot 、es-springboot 、rabbitmq 第三技术
 *   @ComponentScan:            组件扫描  根据注解发挥注解作用  默认扫描当前包 及其子包
 *
 *
 *  启动springboot应用时候需要传递main函数参数作为启动的第二个参数:
 *
 *
 *  java -jar --spring.config.location=绝对路径  xxx.jar
 *
 */