package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by HIAPAD on 2019/11/14.
 */
public interface UserService {
    List<User> findAll();

    User find(String id);

    void save(User user);

    void update(User user);

    void delete(String id);
}
