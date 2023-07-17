package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
@ExcelTarget("card")
@Data
public class Card implements Serializable {
    @Excel(name = "身份证号码",width = 20.0,orderNum = "6")
    private String no;
    @Excel(name = "籍贯",width = 40.0,orderNum = "7")
    private String address;
}
