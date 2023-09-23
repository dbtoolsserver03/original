package com.baizhi.test;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpServiceImpl;

import java.util.List;

public class TestEmpService {
    public static void main(String[] args) {
        EmpServiceImpl empService = new EmpServiceImpl();

        List<Emp> emps = empService.findAll();

        for (Emp emp : emps) {
            System.out.println("emp = " + emp);
        }
    }
}
