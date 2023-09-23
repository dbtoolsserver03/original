package com.baizhiedu.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Product.setName");
        this.name = name;
    }

    public Product() {
        System.out.println("Product.Product");
    }

    //这个就是初始化方法：做一些初始化操作
    // Spring会进行调用
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }

    public void myInit() {
        System.out.println("Product.myInit");
    }

    //销毁方法：销毁操作（资源释放的操作 ）
    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }

    public void myDestroy()throws Exception{
        System.out.println("Product.myDestroy");
    }
}
