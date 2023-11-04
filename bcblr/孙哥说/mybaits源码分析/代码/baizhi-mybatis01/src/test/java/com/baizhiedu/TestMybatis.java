package com.baizhiedu;

import com.baizhiedu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMybatis {

    /**
     *  用于测试:基本的Mybatis开发步骤
     */
    @Test
    public void test1() throws IOException {
      /*  InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);

        List<User> users = userDAO.queryAllUsersByPage();

        for (User user : users) {
            System.out.println("user = " + user);
        }*/
    }

    /**
     *  用于测试:Mybatis SQLSession的第二种用法
     */
    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("com.baizhiedu.dao.UserDAO.queryAllUsers");
                      /*   sqlSession.selectOne()
                           sqlSession.insert()
                           sqlSession.delete()
                           sqlSession.update()*/
        for (User user : users) {
            System.out.println("user = " + user);
        }



    }

    /**
     *  用于测试:JDBC
     */
    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Drvier");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhosttt:3306/suns?useSSL=false", "root", "123456");
//        Statement statement = conn.createStatement();
//        statement.execute(sql);
    }

    /**
     *  用于测试:
     */
    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("");

    }

    /**
     *  用于测试:Proxy
     */
    @Test
    public void testProxy() throws IOException {
    /*    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Class[] interfaces = new Class[]{UserDAO.class};

        UserDAO userDAO = (UserDAO) Proxy.newProxyInstance(TestMybatis.class.getClassLoader(),interfaces
                                                 ,new MyMapperProxy(sqlSession,UserDAO.class));

        List<User> users = userDAO.queryAllUsersByPage();

        for (User user : users) {
            System.out.println("user = " + user);
        }*/

    }

    /**
     *  用于测试:XPathParser
     */
    @Test
    public void testXml() throws IOException {
        //InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //Reader reader = Resources.getResourceAsReader("users.xml");
        InputStream inputStream = Resources.getResourceAsStream("users.xml");
        XPathParser xPathParser = new XPathParser(inputStream);

        //xNodes 里面的xNode 对应 <user>
        //  /configuration/*
        List<XNode> xNodes = xPathParser.evalNodes("/users/*");

        List<com.baizhiedu.xml.User> users = new ArrayList<>();

        //这里面每一个xNode对应就是一个<user>
        for (XNode xNode : xNodes) {
            com.baizhiedu.xml.User user = new com.baizhiedu.xml.User();
            List<XNode> children = xNode.getChildren();
            user.setName(children.get(0).getStringBody());
            user.setPassword(children.get(1).getStringBody());
            users.add(user);
        }

        for (com.baizhiedu.xml.User user : users) {
            System.out.println("user = " + user);
        }




    }



















}
