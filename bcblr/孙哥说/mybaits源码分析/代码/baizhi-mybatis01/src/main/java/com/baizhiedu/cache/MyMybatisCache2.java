package com.baizhiedu.cache;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.ibatis.cache.Cache;
import java.io.Serializable;
import java.util.concurrent.locks.ReadWriteLock;


/**
 * 1. 存数据 (基本变量 数组 List Set Map ) 存多个数据
 * 2. key value
 * redis
 */

public class MyMybatisCache2 implements Cache {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object key, Object value) {
        // redis java client  ---> jedis
         //Jedis jedis = JedisUtils.openJedis();
        //key ---> json  value--->json
        //jedis.set(String,String);
        //key --- byte[] value --- byte[]
        //jedis.set(byte[],byte[]);

        byte[] k = SerializationUtils.serialize((Serializable) key);
        byte[] v = SerializationUtils.serialize((Serializable) value);
        //jedis.set(k, v);
    }

    @Override
    public Object getObject(Object key) {
        if (key != null) {
            byte[] k = SerializationUtils.serialize((Serializable) key);
            //Jedis jedis = JedisUtils.openJedis();
           // byte[] bytes = jedis.get(k);
//            if(bytes !=null){
//                Object value = SerializationUtils.deserialize(bytes);
//                return value;
//            }
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
