package com.mapper;

import com.entity.User;

import java.util.List;

public interface UserMapper {

    void addUser(User user);

    List<User> selectAllUser();

    User getById(Long id);
}


