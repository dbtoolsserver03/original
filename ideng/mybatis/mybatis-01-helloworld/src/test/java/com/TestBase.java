package com;

import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;

public class TestBase {
    SqlSession sqlSession;

    UserMapper userMapper;

    @BeforeEach
    public void testBefore() throws Exception{
        // 读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);

        // 通过SqlSessionFactory创建SqlSession
        sqlSession = ssf.openSession();

        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @AfterEach
    public void testAfter(){
        // 提交事务
        sqlSession.commit();
        // 关闭 SqlSession
        sqlSession.close();
    }
}
