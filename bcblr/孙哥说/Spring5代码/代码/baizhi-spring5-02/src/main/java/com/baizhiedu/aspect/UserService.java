package com.baizhiedu.aspect;

import com.baizhiedu.proxy.User;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
