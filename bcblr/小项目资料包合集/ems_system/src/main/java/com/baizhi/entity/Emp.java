package com.baizhi.entity;

import java.util.Date;

public class Emp {
    private String id;
    private String name;
    private Integer age;
    private Date bir;
    private String deptid;//部门外键

    //对应一个部门
    private Dept dept;//用来处理员工部门信息

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public Emp() {
    }

    public Emp(String id, String name, Integer age, Date bir, String deptid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.deptid = deptid;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                ", deptid='" + deptid + '\'' +
                '}';
    }
}
