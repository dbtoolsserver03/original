package com.concat.dao;

import com.concat.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {

    void save(User user);

    User login(@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
