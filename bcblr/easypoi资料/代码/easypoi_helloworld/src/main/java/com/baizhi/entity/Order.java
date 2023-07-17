package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ExcelTarget("orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Excel(name="订单编号",orderNum = "8",width = 20.0)
    private String no;
    @Excel(name="订单名称",orderNum = "9",width = 15.0)
    private String name;
}
