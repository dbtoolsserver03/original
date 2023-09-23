package com.baizhiedu.factory;

import com.baizhiedu.proxy.User;

public interface UserService {
    public void login(String name, String password);

    public void register(User user);
}
