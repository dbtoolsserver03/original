package com;

import com.entity.User;
import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class TestUserMapper2 {
    SqlSession sqlSession;

    @BeforeEach
    public void testBefore() throws Exception{
        // 读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);

        // 通过SqlSessionFactory创建SqlSession
        sqlSession = ssf.openSession();
    }

    @AfterEach
    public void testAfter(){
        // 提交事务
        sqlSession.commit();
        // 关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testInsert() throws Exception{

        // SqlSession执行文件中定义的SQL，并返回映射结果
        // 添加用户
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");

        sqlSession.insert("com.mapper.UserMapper.addUser", user);
        // 查询所有用户
        List<User> users = sqlSession.selectList("com.mapper.UserMapper.selectAllUser");
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert2(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUserName("李四");
        user.setPassword("123456");

        userMapper.addUser(user);
    }

    @Test
    public void testQuery(){
        // 查询所有用户
        List<User> users = sqlSession.selectList("com.mapper.UserMapper.selectAllUser");
        users.forEach(System.out::println);
    }
}

