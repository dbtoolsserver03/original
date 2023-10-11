package com.baizhi;

import com.baizhi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


public class UserServiceTests extends BasicTests{

    @Autowired
    private UserService userService;

    //测试查询所有
    @Test
    public void testFindAll(){
        userService.findAll().forEach(user-> System.out.println(user.getName()));
    }

}
