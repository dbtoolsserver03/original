package com.boot.service;

import com.boot.entity.User;
import com.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> list(){
        return userMapper.list();
    }

    public void deleteById(Long id){
        userMapper.deleteById(id);
    }

}
