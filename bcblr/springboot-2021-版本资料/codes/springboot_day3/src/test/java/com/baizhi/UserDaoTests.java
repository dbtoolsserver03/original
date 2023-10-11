package com.baizhi;

import com.baizhi.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTests  extends BasicTests{

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll(){
        userDao.findAll().forEach(user-> System.out.println(user.getName()));
    }
}
