package com.baizhiedu.dao;

import com.baizhiedu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    //public void save(User user); //SqlSession.insert()

    public void save(User user);

    public List<User> queryAllUsersByPage();//SqlSesson.select()

    public User queryUserById(@Param("id") Integer id);

    public void update(User user);

}
