package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {

    void save(User user);

    User login(@Param("username") String username,@Param("password") String password,@Param("role")String role);
}
