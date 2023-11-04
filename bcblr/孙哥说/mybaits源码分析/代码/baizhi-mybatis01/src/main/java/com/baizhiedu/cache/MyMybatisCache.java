package com.baizhiedu.cache;


import org.apache.ibatis.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *    1. 存数据 (基本变量 数组 List Set Map ) 存多个数据
 *    2. key value
 */
public class MyMybatisCache implements Cache {

    private Map<Object,Object> internalCache  = new HashMap();

    @Override
    public String getId() {
        return getClass().getName() ;
    }

    @Override
    public void putObject(Object key, Object value) {
          internalCache.put(key,value);
    }

    @Override
    public Object getObject(Object key) {
        return internalCache.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        return internalCache.remove(key);
    }

    @Override
    public void clear() {
        internalCache.clear();
    }

    @Override
    public int getSize() {
        return internalCache.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return new ReentrantReadWriteLock();
    }
}
