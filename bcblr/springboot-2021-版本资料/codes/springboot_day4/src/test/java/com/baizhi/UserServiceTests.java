package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserServiceTests  extends BasicTests{

    @Autowired
    private UserService userService;


    @Test
    public void testSave(){
        userService.save(new User(null,"小黑123456",new Date(),2300.23));
    }

    @Test
    public void testFindAll(){
        userService.findAll().forEach(user-> System.out.println(user.getName()));
    }
}
