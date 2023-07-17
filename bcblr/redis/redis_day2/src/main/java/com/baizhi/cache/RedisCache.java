package com.baizhi.cache;

import com.baizhi.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class RedisCache implements Cache {

    private String id;

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisCache(String id){
        System.out.println("当前加入缓存namespace id:"+id);
        this.id = id;
    }


    @Override
    public String getId() {
        return id;
    }

    //放入缓存 //redisTemplate StringRedisTemplate   RedisTemplate
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("key:" +key);
        System.out.println("value:" +value);
        //获取对象
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        //存储缓存数据
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置hashkey序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        //hash模型
        redisTemplate.opsForHash().put(id.toString(),key.toString(),value);

        if(id.toString().equals("com.baizhi.dao.UserDAO")){
            redisTemplate.expire(id.toString(),10, TimeUnit.DAYS);
        }

        if(id.toString().equals("com.baizhi.dao.EmpDAO")){
            redisTemplate.expire(id.toString(),10, TimeUnit.MINUTES);
        }

    }

    //在缓存中获取
    @Override
    public Object getObject(Object key) {
        //获取对象
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        //存储缓存数据
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置hashkey序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        return redisTemplate.opsForHash().get(id.toString(),key.toString());
    }

    //删除缓存中数据 这个方法没有用到
    @Override
    public Object removeObject(Object key) {
        System.out.println("删除缓存方法未用");
        return null;
    }

    //清空缓存
    @Override
    public void clear() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        System.out.println("清空缓存");
        //存储缓存数据
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //清空当前namespace对应map
        redisTemplate.delete(id.toString());
    }

    //缓存命中率计算
    @Override
    public int getSize() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        //key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //获取当前namespace中缓存数据
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }

    //读写锁   ReadWriteLock   写写互斥  读写不互斥 读读不互斥  synchronized  读 读 互斥  读写 互斥
    @Override
    public  ReadWriteLock getReadWriteLock() {
        return new ReentrantReadWriteLock();
    }
}
