package com;

import com.entity.User;
import com.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUpdate extends TestBase{

    @Test
    public void test01(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("userName","admin");
        map.put("password","123456");
        userMapper.updateMap(map);

        List<User> users = userMapper.selectAllUser();

        users.forEach(System.out::println);
    }

    @Test
    public void test02(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.updateParam(1L,"buyer","000000");

        List<User> users = userMapper.selectAllUser();

        users.forEach(System.out::println);

    }


    @Test
    public void test03(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setId(1L);
        u.setUserName("张丽");
        u.setPassword("1111111");

        userMapper.updateJavaBean(u);

        System.out.println("u = " + u);

        List<User> users = userMapper.selectAllUser();

        users.forEach(System.out::println);

    }

    @Test
    public void test04(){
        User u = new User();
        u.setId(3L);
        u.setUserName("张大丽");
        u.setPassword("1111111");

        userMapper.updateUser(u);

        List<User> users = userMapper.selectAllUser();

        users.forEach(System.out::println);

    }

}
