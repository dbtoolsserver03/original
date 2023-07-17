package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ExcelTarget("users")
public class User implements Serializable {


    @Excel(name="编号")
    private String id;
    @Excel(name="姓名")
    private String name;
    @Excel(name="生日",format = "yyyy年MM月dd日",width = 15.0)
    private Date bir;
    @Excel(name="爱好",width = 15.0)
    private String habbys;
    @Excel(name="头像信息",width = 22,type = 2,savePath = "/Users/chenyannan/IdeaProjects/180codes/easypoi_springboot/src/main/resources/static/imgs")
    private String photo;
    @Excel(name="身份证号",width = 18.0)
    private String no;
    @Excel(name="家庭住址",width = 20.0)
    private String address;


}
