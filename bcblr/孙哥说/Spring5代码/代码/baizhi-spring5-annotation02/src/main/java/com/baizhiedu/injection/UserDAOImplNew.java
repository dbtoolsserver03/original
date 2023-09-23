package com.baizhiedu.injection;

public class UserDAOImplNew implements UserDAO {
    @Override
    public void save() {
        System.out.println("UserDAOImplNew.save");
    }
}
