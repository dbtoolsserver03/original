package com;

import com.entity.User;
import org.junit.jupiter.api.Test;

public class TestJoin extends TestBase{
    @Test
    public void getById(){
        User user = userMapper.getById(2L);
        System.out.println(user);
    }

    @Test
    public void getByIdLeftJoin(){
        User user = userMapper.getByIdLeftJoin(2L);
        System.out.println("user = " + user);
    }

}
