package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.ibatis.cache.Cache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;


    @Test
    public void testDelete(){
        userService.delete("3e6a8d9c-fed2-4409-bd3a-ba46501b4da5");
    }

    @Test
    public void testUpdate(){
        userService.update(new User("73446716-2404-4fca-b023-8b05cf7e3ba0","小三3",23,new Date()));
    }

    //添加数据
    @Test
    public void testSave(){
        userService.save(new User(null,"小三",23,new Date()));
    }


    @Test
    public void testFindOne(){
        Cache cache;
        userService.find("9be0f684-6539-4a68-a956-d1427c7a4382");
        System.out.println("==============");
        userService.find("9be0f684-6539-4a68-a956-d1427c7a4382");
    }

    @Test
    public void testFindAll(){
        Cache cache;
        userService.findAll();
        System.out.println("==============");
        userService.findAll();
    }
}
