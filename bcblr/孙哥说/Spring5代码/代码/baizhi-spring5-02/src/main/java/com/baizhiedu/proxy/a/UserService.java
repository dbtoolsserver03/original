package com.baizhiedu.proxy.a;

import com.baizhiedu.proxy.User;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
