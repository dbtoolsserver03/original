package com.baizhiedu.service;

import com.baizhiedu.entity.User;

public interface UserService {
    public void register(User user) throws Exception;

    public void login(String name,String password);
}
