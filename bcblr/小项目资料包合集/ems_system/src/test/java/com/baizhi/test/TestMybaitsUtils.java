package com.baizhi.test;

import com.baizhi.utils.MybatisUtils;

public class TestMybaitsUtils {
    public static void main(String[] args) {
        MybatisUtils.getSqlSession().commit();
    }
}
