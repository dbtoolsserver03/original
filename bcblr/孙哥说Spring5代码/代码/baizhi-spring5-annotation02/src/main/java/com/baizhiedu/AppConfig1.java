package com.baizhiedu;

import com.baizhiedu.bean.Customer;
import com.baizhiedu.injection.UserDAO;
import com.baizhiedu.injection.UserDAOImpl;
import com.baizhiedu.injection.UserService;
import com.baizhiedu.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/init.properties")
public class AppConfig1 {

    @Value("${id}")
    private Integer id;
    @Value("${name}")
    private String name;


    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

   /* @Bean
    public UserService userService(UserDAO userDAO) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }
*/

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO());
        return userService;
    }

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);

        return customer;
    }















}
