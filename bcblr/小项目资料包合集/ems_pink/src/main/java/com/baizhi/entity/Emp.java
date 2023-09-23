package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {
    private String id;
    private String name;
    private Double salary;
    private Integer age;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date bir;
    private String path;

}
