package com;

import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestUserMapper {

    @Test
    public void testInsert() throws Exception{
        // 读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        // 通过SqlSessionFactory创建SqlSession
        SqlSession ss = ssf.openSession();
        // SqlSession执行文件中定义的SQL，并返回映射结果
        // 添加用户
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");

        ss.insert("com.mapper.UserMapper.addUser", user);
        // 查询所有用户
        List<User> users = ss.selectList("com.mapper.UserMapper.selectAllUser");
        users.forEach(System.out::println);
        // 提交事务
        ss.commit();
        // 关闭 SqlSession
        ss.close();
    }

}


