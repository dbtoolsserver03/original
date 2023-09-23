package com.car.service;


import com.car.dao.UserDAO;
import com.car.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String password, String role) {
        return userDAO.login(username,password,role);
    }

    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }
}
