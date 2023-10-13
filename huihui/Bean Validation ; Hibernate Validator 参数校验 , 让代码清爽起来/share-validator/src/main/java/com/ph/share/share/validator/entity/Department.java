package com.ph.share.share.validator.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

/**
 *       String errorPrefix = "添加失败，";
 *         if (department.getId() != null) {
 *             return errorPrefix + "实体参数异常";
 *         }
 *         if (department.getParentId() == null) {
 *             return errorPrefix + "父机构异常";
 *         }
 *         if (department.getParentId() < 0) {
 *             return errorPrefix + "父机构不存在";
 *         }
 *         if (department.getName() == null || department.getName().equals("")) {
 *             return errorPrefix + "名称不能为空";
 *         }
 *         if (department.getCreateTime() == null) {
 *             department.setCreateTime(LocalDateTime.now());
 *         }else {
 *             if (department.getCreateTime().isAfter(LocalDateTime.now())) {
 *                 return errorPrefix + "创建时间不能大于当前时间";
 *             }
 *         }
 *
 *
 *
 *
 *          * id           必须是 null
 *          * parentId    不能为 null，必须大于 0
 *          * name         不能为空，长度必须大于 0
 *          * createTime   肯定不是未来的时间
 *
 */
public class Department {
    /**
     * 主键
     */
    @Null(message = "主键不可以有值")
    private Integer id;
    /**
     * 父级 ID
     */
    @NotNull
    private Integer parentId;
    /**
     * 部门名臣
     */
    @NotBlank
    private String name;
    /**
     * 成立时间
     */
    @NotNull
    @PastOrPresent
    private LocalDateTime createTime;


    private List<@Valid Employee> employeeList;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
