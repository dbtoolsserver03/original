package com.fruit.dao;

import com.fruit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {

    void save(User user);

    User login(@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
