package com.baizhi.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save(String name) {
        System.out.println("name = " + name);
    }
}
