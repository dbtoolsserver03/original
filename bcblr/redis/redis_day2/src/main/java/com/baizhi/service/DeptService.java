package com.baizhi.service;

import com.baizhi.entity.Dept;

import java.util.List;

/**
 * Created by HIAPAD on 2019/11/14.
 */
public interface DeptService {
    List<Dept> findAll();

    Dept find(String id);

    void save(Dept dept);

    void update(Dept dept);

    void delete(String id);
}
