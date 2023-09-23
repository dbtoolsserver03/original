package com.baizhiedu.injection;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public void save() {
        System.out.println("UserDAOImpl.save");
    }
}
