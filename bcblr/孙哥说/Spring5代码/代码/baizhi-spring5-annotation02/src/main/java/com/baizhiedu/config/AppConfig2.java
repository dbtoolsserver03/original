package com.baizhiedu.config;

import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }
}
