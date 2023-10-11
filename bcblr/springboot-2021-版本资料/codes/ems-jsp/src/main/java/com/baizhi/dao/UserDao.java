package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {

    //根据用户名查询用户
    User findByUserName(String username);

    //注册用户
    void save(User user);
}
