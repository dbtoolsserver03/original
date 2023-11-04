package com.baizhiedu.dao;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void save() {
        System.out.println("jdbc 的方式操作 数据库 完成 插入的操作");
    }

    @Override
    public Product queryProductById(int id) {
        System.out.println("jdbc 的方式基于ID 进行查询 " + id);
        return new Product();
    }

    @Override
    public List<Product> queryAllProducts() {
        System.out.println("jdbc 的方式进行全表查询 ");
        return new ArrayList();
    }
}
