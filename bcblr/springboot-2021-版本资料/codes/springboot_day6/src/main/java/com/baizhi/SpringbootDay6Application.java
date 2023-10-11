package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//SpringBootServletInitializer: 不在使用内嵌容器启动,使用外部tomcat容器启动
@SpringBootApplication
public class SpringbootDay6Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDay6Application.class, args);
    }



    //配置入口类是谁
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootDay6Application.class);
    }
}
