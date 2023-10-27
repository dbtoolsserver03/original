package com;

import com.entity.User;
import com.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestInsert extends TestBase{

    @Test
    public void test01(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("userName","小王同学");
        map.put("password","123456");
        userMapper.insertMap(map);

        List<User> users = userMapper.selectAllUser();

        users.forEach(System.out::println);

    }

    @Test
    public void test02(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.insertParam("小张同学","123456");

        List<User> users = userMapper.selectAllUser();

        users.forEach(System.out::println);

    }

    @Test
    public void test03(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setUserName("张三");
        u.setPassword("123456");

        userMapper.insertJavaBean(u);

        System.out.println("u = " + u);

        List<User> users = userMapper.selectAllUser();

        users.forEach(System.out::println);

    }

    @Test
    public void test04(){
        User u1 = new User();
        u1.setAddTime(new Date());
        u1.setUserName("张三1");
        u1.setPassword("123456");

        User u2 = new User();
        u2.setAddTime(new Date());
        u2.setUserName("张三2");
        u2.setPassword("123456");

        User[] users = {u1,u2};

        userMapper.foreachInsert(users);

    }

}
