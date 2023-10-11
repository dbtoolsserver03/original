package com.baizhi.dao;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    //查询员工信息列表
    List<Employee> list();

    //添加员工信息
    void add(Employee employee);

    //根据id查询员工信息
    Employee idByEmployee(Integer id);

    //更新员工信息
    void update(Employee employee);

    //根据id删除员工信息
    void delete(Integer id);
}
