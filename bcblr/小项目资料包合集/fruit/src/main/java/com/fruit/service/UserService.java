package com.fruit.service;


import com.fruit.entity.User;

public interface UserService {

    void register(User user);

    User login(String username, String password, String role);
}
