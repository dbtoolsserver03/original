package com.ph.share.share.validator.entity;

import com.ph.share.share.validator.validation.sequenceprovider.EmployeeGroupSequenceProvider;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@GroupSequenceProvider(EmployeeGroupSequenceProvider.class)
public class Employee {

    public interface Add {
    }

    public interface Update {
    }


    /**
     * 如果指定了验证组，那么该参数就只属于 指定的验证组
     * <p>
     * 如果没有指定验证组，那么该参数属于 默认组
     */


    @Null(groups = {Add.class})   //在添加的时候生效
    @NotNull(groups = Update.class)    //在修改的时候生效
    private Integer id;

    @NotEmpty
    private String name;

    @Valid
    private Department department;


    /**
     * 举例
     * 1、员工的 age 在 20-25 之间，title 必须以 "初级" 开头
     * 2、员工的 age 在 25-30 之间，title 必须以 "中级" 开头
     * 3、否则，不做验证
     */


    public interface TitleJunior { }
    public interface TitleMiddle { }

    @NotNull
    private Integer age;

    @NotEmpty
    @Pattern(regexp = "^\u521d\u7ea7.*",groups = TitleJunior.class)        //初级
    @Pattern(regexp = "^\u4e2d\u7ea7.*",groups = TitleMiddle.class)           //中级
    private String title;



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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
