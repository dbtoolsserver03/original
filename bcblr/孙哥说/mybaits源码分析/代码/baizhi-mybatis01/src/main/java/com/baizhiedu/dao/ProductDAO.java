package com.baizhiedu.dao;


import java.util.List;

public interface ProductDAO {
    public void save();

    public Product queryProductById(int id);

    @Cache
    public List<Product> queryAllProducts();
}
