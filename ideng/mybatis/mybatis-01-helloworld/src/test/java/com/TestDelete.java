package com;

import com.entity.User;
import com.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDelete extends TestBase{

    @Test
    public void test01(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1L);

        List<User> users = userMapper.selectAllUser();
        users.forEach(System.out::println);
        userMapper.deleteMap(map);

        users = userMapper.selectAllUser();
        users.forEach(System.out::println);


    }

    @Test
    public void test02(){
        List<User> users = userMapper.selectAllUser();
        users.forEach(System.out::println);

        userMapper.deleteParam(2L);

        users = userMapper.selectAllUser();
        users.forEach(System.out::println);


    }

    @Test
    public void test03(){
        List<User> users = userMapper.selectAllUser();
        users.forEach(System.out::println);

        User user = new User();
        user.setId(3L);
        userMapper.deleteJavaBean(user);

        users = userMapper.selectAllUser();
        users.forEach(System.out::println);


    }

}
