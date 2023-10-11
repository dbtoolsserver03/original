package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 分类(Category)实体类
 *
 * @author makejava
 * @since 2021-07-15 17:08:34
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // 用在类上  用来指定json数据中包含哪些数据 JsonInclude.Include.NON_NULL 只要json中不为空的属性
public class Category implements Serializable {
    private static final long serialVersionUID = -41621578636280469L;

    private Integer id;
    /**
     * http://localhost:9999/category/categories     * 名称
     */
    private String name;
    /**
     * 父级分类id
     */
    //jsonproperty  不仅适用于序列化 json数据    还是用json数据反序列化
    @JsonProperty("parent_id")
    private Integer parentId;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private List<Category> children;//多个孩子

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

}
