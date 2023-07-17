package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ExcelTarget("emps")
public class Emp  implements Serializable {

    @Excel(name="编号")
    private String id;
    @Excel(name="姓名")
    private  String  name;
    @Excel(name="年龄")
    private Integer age;
    @Excel(name="生日",format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;
    @Excel(name="状态",replace = {"激活_1","锁定_0"})
    private String status;

    @Excel(name="头像",type = 2,savePath = "/Users/chenyannan/IdeaProjects/180codes/easypoi_helloworld/src/main/imgs")
    private String photo;
}
