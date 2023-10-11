package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper //只能创建单个Dao对象
public interface UserDao {

    //查询所有
    List<User> findAll();

    //保存用户信息
    void save(User user);
}
