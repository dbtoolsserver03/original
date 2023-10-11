package com.baizhi.dao;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpDAO {

    //保存
    void save(Emp emp);

    //查询所有
    List<Emp> findAll();
}
