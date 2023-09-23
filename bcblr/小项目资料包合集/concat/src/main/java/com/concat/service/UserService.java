package com.concat.service;


import com.concat.entity.User;

public interface UserService {

    void register(User user);

    User login(String username, String password, String role);
}
