package com.baizhiedu.proxy;

import org.apache.ibatis.session.SqlSession;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy implements InvocationHandler {

    private SqlSession sqlSession;
    private Class daoClass;

    public MyMapperProxy(SqlSession sqlSession, Class daoClass) {
        this.sqlSession = sqlSession;
        this.daoClass = daoClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(daoClass.getName() + "." + method.getName());
        return sqlSession.selectList(daoClass.getName() + "." + method.getName());
    }
}
