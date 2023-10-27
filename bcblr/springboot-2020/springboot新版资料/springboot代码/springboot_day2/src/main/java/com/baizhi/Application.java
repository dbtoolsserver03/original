package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication  //组合注解: @EnableAutoConfiguration 和  @ComponentScan
@ImportResource("spring.xml")
public class Application {
    //主入口类
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}


/**
 *   在springboot中提供两种方式配置class 通过springboot 管理自定义java class
 *
 *      a.java config  java配置 自定义java对象管理     [推荐]
 *
 *          @Configuration 注解类似于@Component注解  多个自定义对象管理  [推荐]
 *          @import        注解导入一个配置类         导入指定对象
 *
 *
 *      b.xml方式配置   通过xml配置管理java对象         [了解]
 *          @ImportResource("spring.xml")
 */


