package com.baizhi;

import com.baizhi.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTests {

    private UserDao userDao;

    @Autowired
    public UserDaoTests(UserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    public void testFindAll(){
        userDao.findAll().forEach(user-> System.out.println(user));
    }
}
