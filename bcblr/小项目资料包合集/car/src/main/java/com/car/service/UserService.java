package com.car.service;


import com.car.entity.User;

public interface UserService {

    void register(User user);

    User login(String username, String password, String role);
}
