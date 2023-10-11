package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        //1.根据用户查询数据库是否存在改用户名
        User userDB = userDao.findByUserName(user.getUsername());
        if (!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("用户名已存在!");
        //2.进行注册之前给明文加密
        String passwordSecret = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(passwordSecret);
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        //1.根据用户输入用户名查询数据中是否存在
        User user = userDao.findByUserName(username);
        //2.判断对象是否存在
        if (ObjectUtils.isEmpty(user)) throw new RuntimeException("用户名输入错误!");
        //3.判断密码正确性
        String digestPassword = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!user.getPassword().equals(digestPassword)) throw new RuntimeException("密码输入错误!");
        return user;
    }
}
