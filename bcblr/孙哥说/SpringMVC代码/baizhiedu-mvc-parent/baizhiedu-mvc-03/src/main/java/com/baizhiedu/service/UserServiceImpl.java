package com.baizhiedu.service;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
       userDAO.save(user);
    }
}
