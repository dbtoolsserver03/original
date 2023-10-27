package com;

import com.entity.User;
import com.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSelect extends TestBase{

    @Test
    public void test01(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<>();
        map.put("id",1L);
        User user = userMapper.selectUserById(map);
        System.out.println(user);
    }

    @Test
    public void test02(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectUserByUserNameAndPassword("张三","123456");

        System.out.println(user);
    }

    @Test
    public void test03(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User u = new User();
        u.setUserName("张三");
        u.setPassword("123456");
        User user = userMapper.selectUserByJavaBean(u);

        System.out.println(user);
    }

    @Test
    public void test04(){
        User user = userMapper.getByUsername(null,2L);
        System.out.println("user = " + user);
    }

    @Test
    public void test05(){
        List<User> users = userMapper.getByUsernameAndPassword(null, null);
        users.forEach(System.out::println);
    }

    @Test
    public void test06(){
        List<User> users = userMapper.getByIdCheck(10L);
        users.forEach(System.out::println);
    }

    @Test
    public void test07(){
        List<Long> ids = Arrays.asList(1L,2L,3L,4L,5L);
        List<User> users = userMapper.foreachQuery(ids);
        users.forEach(System.out::println);
    }

    @Test
    public void test08(){
        List<User> users = userMapper.bindQuery("张", "2");
        users.forEach(System.out::println);
    }

    @Test
    public void test09(){
        List<User> users = userMapper.cdataQuery(10L);
        users.forEach(System.out::println);
    }

    @Test
    public void test10(){
        List<User> users = userMapper.selectTrim(null, "123");
        users.forEach(System.out::println);
    }

}
