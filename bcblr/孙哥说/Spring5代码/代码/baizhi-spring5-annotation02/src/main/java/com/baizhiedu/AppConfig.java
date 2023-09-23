package com.baizhiedu;

import com.baizhiedu.bean.ConnectionFactoryBean;
import com.baizhiedu.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class AppConfig {


    /**
     * 简单对象
     * @return
     */
    @Bean("u")
    /*@Scope("singleton")
    */
    public User user(){
        return new User();
    }

    /**
     * 创建复杂对象
     * Connection 不能直接通过new 创建
     */
    @Bean
    public Connection conn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suns?useSSL=false", "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    @Bean
    public Connection conn1() {
        Connection conn = null;
        try {
            ConnectionFactoryBean factoryBean = new ConnectionFactoryBean();
            conn = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
