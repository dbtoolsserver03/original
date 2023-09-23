package com.concat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private String id;
    private String name;
    private String number;
    private String ship;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date bir;
    private String path;

}
