package com.baizhi;

import org.apache.ibatis.annotations.MapKey;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class SpringbootDay10Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDay10Application.class, args);
    }

}
