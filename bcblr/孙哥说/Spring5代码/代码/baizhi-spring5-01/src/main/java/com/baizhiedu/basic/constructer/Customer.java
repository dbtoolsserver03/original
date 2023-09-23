package com.baizhiedu.basic.constructer;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private int age;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int age) {
        this.age = age;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
