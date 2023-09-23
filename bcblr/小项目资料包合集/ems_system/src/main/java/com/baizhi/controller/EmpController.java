package com.baizhi.controller;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.service.DeptServiceImpl;
import com.baizhi.service.EmpServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class EmpController extends ActionSupport {


    private String name;
    private Integer age;
    private Date bir;
    private String deptid;
    private String id;







    public String update(){
        EmpServiceImpl empService = new EmpServiceImpl();
        empService.update(new Emp(id,name,age,bir,deptid));
        return "success";
    }


    public String findOne(){
        //1.接收数据
        //2.调用业务方法
        EmpServiceImpl empService = new EmpServiceImpl();
        DeptServiceImpl deptService = new DeptServiceImpl();
        //不仅要传递员工信息
        Emp emp = empService.findOne(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("emp",emp);
        //还要传递部门信息
        List<Dept> depts = deptService.findAll();
        request.setAttribute("depts",depts);

        return "success";
    }

    public String delete(){
        //1.收集删除id
        //2.调用业务方法
        EmpServiceImpl empService = new EmpServiceImpl();
        empService.delete(id);
        //3.处理响应
        return "success";
    }


    public String save(){
        //1.接收数据
        EmpServiceImpl empService = new EmpServiceImpl();
        empService.save(new Emp(null,name,age,bir,deptid));
        return "success";
    }

    public String findAll(){
        //1.收集  2.调用业务
        EmpServiceImpl empService = new EmpServiceImpl();
        List<Emp> emps = empService.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("emps",emps);
        System.out.println("进入 emp findAll");
        return "ok";
    }


//    get/set方法接收数据
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
