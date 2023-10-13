package com.ph.share.share.validator.entity;

import com.ph.share.share.validator.validation.MultipleOfThree;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class Job {
    /**
     * 1、注解一般不会管 null 的情况（null 这种情况,由@NotNull 去负责）      （代码控制）
     * 2、同一个注解，可以对多种参数类型生效
     */
    /**
     * 加入现在有这么一个场景
     *  1、对于 Integer 而言，必须是 3 的倍数
     *  2、对于 List 而言，list 中的元素个数，必须是 3 的倍数
     *
     *
     *  准备写一个注解，去实现  “3 的倍数“ 的验证
     *  这个注解支持两种数据类型 Integer、List
     *
     */

    @MultipleOfThree
    private Integer id;

    @Size(min = 1)
    private String name;

    @Size(min = 1,max = 10)
    @NotNull
    @MultipleOfThree
    private List<String> labels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
