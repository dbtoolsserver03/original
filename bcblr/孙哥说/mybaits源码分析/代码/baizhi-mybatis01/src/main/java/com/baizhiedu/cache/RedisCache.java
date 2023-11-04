package com.baizhiedu.cache;

import com.baizhiedu.util.JedisUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {


    private static final Logger log = LoggerFactory.getLogger(RedisCache.class);
    private String id;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        log.debug("");
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        //存储Redis
        //1. RedisClient
        // Jedis Resession 创建Jedis 对象 ----->  Connection
        //Connection 负责连接数据库 ip port 连接池
        //Jedis 负责连接Redis ip port 连接池 ---> JedisUtils

        log.info("put key is "+key+ " value is "+value);
        //log.debug("");
        Jedis jedis = JedisUtils.getJedis();
        jedis.set(SerializationUtils.serialize((Serializable)key),
                  SerializationUtils.serialize((Serializable)value));

    }

    @Override
    public Object getObject(Object key) {

        log.info("get key is "+key);
        Jedis jedis = JedisUtils.getJedis();
        byte[] bs = jedis.get(SerializationUtils.serialize((Serializable) key));
        if (bs == null) {
            return null;
        }
        return SerializationUtils.deserialize(bs);
    }

    @Override
    // 删除，并且 获取
    public Object removeObject(Object key) {
        byte[] bs = new byte[0];
        try {
            bs = JedisUtils.getJedis().get(SerializationUtils.serialize((Serializable)key));
            JedisUtils.getJedis().del(SerializationUtils.serialize((Serializable)key));
        } catch (Exception e) {
            if (log.isDebugEnabled())
                log.debug("remove handler ocurr exception ", e);
        }
        return SerializationUtils.deserialize(bs);
    }

    @Override
    public void clear() {
        if (log.isDebugEnabled())
            log.debug("");
           JedisUtils.getJedis().flushDB();
    }

    @Override
    public int getSize() {
        return JedisUtils.getJedis().dbSize().intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
