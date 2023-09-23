package com.baizhi.dao;

import com.baizhi.entity.Dept;

import java.util.List;

public interface DeptDAO {

    List<Dept> findAll();

    void save(Dept dept);

    Dept findOne(String id);

    void update(Dept dept);
}
