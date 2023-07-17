package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ExcelTarget("users")
public class User implements Serializable {

    @Excel(name="编号",orderNum = "0")
    //@ExcelIgnore
    private String id;
    @Excel(name="姓名",orderNum = "1")
    private String name;
    @Excel(name="年龄",orderNum = "3",suffix = " &",replace = {"10岁_10","11岁_11"})
    private Integer age;
    @Excel(name="生日",width = 35.0,format = "yyyy-MM-dd HH:mm:ss",orderNum = "2")
    private Date bir;

    @Excel(name="状态",replace = {"激活_1","锁定_0"},orderNum = "4")
    private String status;

    //@Excel(name="爱好",width = 20.0,orderNum = "5")
    @ExcelIgnore
    private List<String> habbys;//喜好

    @Excel(name="爱好",width = 20.0,orderNum = "5")
    private String habbyStr;//爱好字符串

    public String getHabbyStr() {
        StringBuilder sb = new StringBuilder();
        habbys.forEach(e->{
            sb.append(e).append("、");
        });
        return sb.toString();
    }

    @ExcelEntity  //标识一对一关系
    private Card card;

    @ExcelCollection(name="订单列表",orderNum = "8") //标识一对多的关系
    private List<Order> orders;


    @Excel(name="头像",width = 20,height = 20,type = 2,imageType = 1) //type=2 为图片类型
    private String photo;//头像信息


}
