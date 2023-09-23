package com.baizhi.test;

import com.baizhi.entity.Dept;
import com.baizhi.service.DeptServiceImpl;

import java.util.List;

public class TestDeptService {
    public static void main(String[] args) {

        DeptServiceImpl deptService = new DeptServiceImpl();

        deptService.save(new Dept(null,"医疗部",null,null));


        //findAll
        List<Dept> all = deptService.findAll();
        for (Dept dept : all) {
            System.out.println(dept);
        }
    }
}
