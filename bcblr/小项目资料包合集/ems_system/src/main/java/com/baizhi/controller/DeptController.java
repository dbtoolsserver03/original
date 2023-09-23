package com.baizhi.controller;

import com.baizhi.entity.Dept;
import com.baizhi.service.DeptServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class DeptController extends ActionSupport {


    private String name;//部门

    public String save(){
        //1.收集数据  2.调用业务  3.处理响应
        DeptServiceImpl deptService = new DeptServiceImpl();
        deptService.save(new Dept(name));
        return "success";
    }


    /**
     * 跳转到员工添加页面查询所有部门
     */
    public String findAllForwardEmpAdd(){
        findAllDepts();//调用方法
        return "success";
    }

    /**
     * 部门页面查询所有
     * @return
     */
    public String findAll(){
        findAllDepts();//调用封装方法
        return "ok";
    }

    //封装查询所有公共方法
    private void findAllDepts(){
        //1.收集数据
        //2.调用业务方法
        DeptServiceImpl deptService = new DeptServiceImpl();
        List<Dept> depts = deptService.findAll();
        //放入作用域 request
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("depts",depts);
    }


    //get set方法用来接收参数

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
