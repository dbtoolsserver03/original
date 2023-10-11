package com.baizhi;

import com.baizhi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTests extends  BasicTests{

    @Autowired
    private UserService userService;


    @Test
    public void testSave(){
        userService.save("小陈");
    }

    @Test
    public void testDelete(){
        userService.delete(21);
    }

    @Test
    public void testFind(){
        String name  = userService.find("xiaochen");
        System.out.println(name);
    }

    @Test
    public void testFileName(){
        String fileName = "aaa.xxx.md";
        int i = fileName.lastIndexOf(".");
        String substring = fileName.substring(i);
        System.out.println(substring);
    }


}
