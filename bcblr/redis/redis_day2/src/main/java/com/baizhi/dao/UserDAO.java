package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by HIAPAD on 2019/11/14.
 */
public interface UserDAO {

    List<User> findAll();


    User find(String id);

    void save(User user);

    void update(User user);

    void delete(String id);

}
