package com.baizhiedu.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession session = sqlSessionFactory.openSession();
        UserDAO userDAO = session.getMapper(UserDAO.class);


        User user = new User();
        user.setName("suns");
        user.setPassword("123456");
        userDAO.save(user);

        session.commit();
    }
}
