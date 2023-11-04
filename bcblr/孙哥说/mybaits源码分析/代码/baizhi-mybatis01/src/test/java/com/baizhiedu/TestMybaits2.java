package com.baizhiedu;

import com.baizhiedu.dao.Cache;
import com.baizhiedu.dao.ProductDAO;
import com.baizhiedu.dao.ProductDAOImpl;
import com.baizhiedu.entity.User;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.ibatis.cache.decorators.LoggingCache;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMybaits2 {
    /**
     * 用于测试:创建DAO接口的代理
     */
    @Test
    public void test() {
        ProductDAO productDAO = new ProductDAOImpl();
        ProductDAO productDAOProxy = (ProductDAO) Proxy.newProxyInstance(TestMybaits2.class.getClassLoader(), new Class[]{ProductDAO.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //方法 只有以query开头，在进行缓存的处理 如果不是以query开头，就直接运行
//                if (method.getName().startsWith("query")) {
//                    System.out.println("连接redis 查看数据是否 存在 如果存在 则直接返回 return data");
//                    return method.invoke(productDAO, args);
//                }
                Cache cache = method.getDeclaredAnnotation(Cache.class);
                if (cache != null) {
                    System.out.println("连接redis 查看数据是否 存在 如果存在 则直接返回 return data");
                    return method.invoke(productDAO, args);
                }

                //非查询方法
                return method.invoke(productDAO, args);
            }
        });

        productDAOProxy.save();
        System.out.println("---------------------------------");
        productDAOProxy.queryProductById(10);
        System.out.println("---------------------------------");
        productDAOProxy.queryAllProducts();
    }

    /**
     * 用于测试:commons-langs 包 序列化操作
     */
    @Test
    public void test1() {
        byte[] serialize = SerializationUtils.serialize((Serializable) new User(1, "suns"));
        System.out.println(serialize);
        Object deserialize = SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);

    }

    /**
     * 用于测试:Cache 与 装饰器
     */
    @Test
    public void test2() {
        PerpetualCache perpetualCache = new PerpetualCache("sunshuai");
        LruCache lruCache = new LruCache(perpetualCache);
        LoggingCache loggingCache = new LoggingCache(lruCache);
    }


}
