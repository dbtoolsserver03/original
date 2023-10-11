package com.baizhi.service;

import com.baizhi.annotations.MyAdvice;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{



    @Override
    public void save(String name) {
        System.out.println("处理save核心业务逻辑,调用DAO~~");
    }

    @Override
    public void delete(Integer id) {
        System.out.println("处理delete核心业务逻辑,调用DAO~~");
    }

    @Override
    public void update(String name) {
        System.out.println("处理update核心业务逻辑,调用DAO~~");
    }

    @Override
    @MyAdvice
    public String find(String name) {
        System.out.println("处理find核心业务逻辑,调用DAO~~");
        return name;
    }
}
