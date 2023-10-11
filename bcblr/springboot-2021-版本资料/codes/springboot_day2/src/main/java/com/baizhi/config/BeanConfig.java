package com.baizhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;


@Configuration //修饰范围: 只能用在类上  作用:代表这个类是一个配置类 ====> spring.xml
public class BeanConfig {


    @Bean  //修饰范围:用在方法上或者注解上 作用: 用来将方法返回值交给工厂管理
           //方法名: 推荐返回值首字母小写 代表当前创建对象在工厂中名称
    public Calendar calendar(){
        return Calendar.getInstance();
    }


}
