package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Mapper 注解: 修饰范围: 只能放在Dao接口上  作用:用来在工厂中创建dao对象
@MapperScan("com.baizhi.dao") //修饰范围: 用在类上 作用:用来扫描dao接口所在包 同时将所有dao接口在工厂中创建对象
public class SpringbootDay3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDay3Application.class, args);
    }

}
