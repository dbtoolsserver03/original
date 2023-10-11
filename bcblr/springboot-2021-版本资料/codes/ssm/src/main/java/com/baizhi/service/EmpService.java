package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {

    void save(Emp emp);

    List<Emp> findAll();
}
