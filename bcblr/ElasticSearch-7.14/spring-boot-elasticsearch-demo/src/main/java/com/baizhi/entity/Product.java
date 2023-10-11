package com.baizhi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Document: 将这个类对象转为 es 中一条文档进行录入
 *      indexName: 用来指定文档的索引名称
 *      createIndex: 用来指定是否创建索引
 */
//@Document(indexName = "products",createIndex = true)
public class Product {

    //@Id  //用来将放入对象 id 值 作为文档_id 进行映射
    private Integer id;
    //@Field(type = FieldType.Keyword)
    private String title;
    //@Field(type = FieldType.Double)
    private Double price;
    //@Field(type = FieldType.Text)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
