package com.boot;


import com.boot.entity.User;
import com.boot.mapper.UserMapper;
import com.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest(classes = AppMyBatis.class)
public class MyBatisTest {

    @Autowired
    UserService userService;

    @Test
    public void test01(){
        List<User> all = userMapper.queryAllUser();
        all.forEach(System.out::println);
        log.debug("这里是测试日志。。。。。");
    }

    @Test
    public void test02(){
        userService.deleteById(2L);
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void test03(){
        User user = new User();
        user.setAddTime(new Date());
        user.setUserName("张三");
        user.setPassword("1234567890");

        userMapper.insert(user);

        System.out.println("user = " + user);

    }

    @Test
    public void test04(){
        userMapper.queryAllUser().forEach(System.out::println);
        userMapper.queryAllUser().forEach(System.out::println);
    }

    @Test
    public void test05(){
        User user = new User();
        user.setId(13L);
        user.setAddTime(new Date());
        user.setUserName("李四。。。。");
        user.setPassword("1234567890");

        userMapper.updateUserById(user);

    }

    @Test
    public void test06(){
        userMapper.delById(13L,"张三");
    }

    @Test
    public void getUserById(){
        User user = userMapper.getUserById(3L);
        System.out.println(user);
        user.getMenus().forEach(System.out::println);
    }

    @Test
    public void pages(){

        int current = 3;//页码
        int pageSize = 10;//每页返回条数
        List<User> users = userMapper.pages((current - 1) * pageSize,pageSize);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert2(){
        User user = new User();
        user.setUserName("李四");
        user.setPassword("123456");

        userMapper.addUser(user);

        System.out.println("user = " + user);
    }


}

