package com.baizhiedu.config;

import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserService;
import com.baizhiedu.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.baizhiedu.injection")
public class AppConfig3 {

    @Autowired
    private UserDAO userDAO;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }
}
