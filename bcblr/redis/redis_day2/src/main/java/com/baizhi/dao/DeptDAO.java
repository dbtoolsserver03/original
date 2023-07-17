package com.baizhi.dao;

import com.baizhi.entity.Dept;

import java.util.List;

/**
 * Created by HIAPAD on 2019/11/14.
 */
public interface DeptDAO {

    List<Dept> findAll();


    Dept find(String id);

    void save(Dept dept);

    void update(Dept dept);

    void delete(String id);

}
