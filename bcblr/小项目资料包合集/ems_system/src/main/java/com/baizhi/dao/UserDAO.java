package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO {


    User findByUserName(String username);

    void update(User user);
}
