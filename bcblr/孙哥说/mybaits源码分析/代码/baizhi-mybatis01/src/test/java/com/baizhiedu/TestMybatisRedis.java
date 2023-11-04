package com.baizhiedu;

import com.baizhiedu.entity.User;
import com.baizhiedu.util.JedisUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TestMybatisRedis {
    /**
     * 用于测试:Jedis
     */
    @Test
    public void test1() {
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("name", "suns");
        JedisUtils.close(jedis);
    }

    /**
     * 用于测试:Jedis.set操作
     */
    @Test
    public void test2() {
        Jedis jedis = JedisUtils.getJedis();
        /*强烈不建议用String
         * 1. String 占地方大
         * 2. MyBatis CacheKey
         * */

        //操作的数据 必须是能序列化
        //序列化技术 实现这个操作 apache lang3
        String key = "name";
        //String value = "suns";

        List<User> users = Arrays.asList(new User(1,"suns"),new User(2,"xiaohei"));

        byte[] k = SerializationUtils.serialize(key);
        byte[] v = SerializationUtils.serialize((Serializable)users);

        jedis.set(k,v);
    }

    /**
     * 用于测试:Jedis.set操作
     */
    @Test
    public void test3() {
        Jedis jedis = JedisUtils.getJedis();
        /*强烈不建议用String
         * 1. String 占地方大
         * 2. MyBatis CacheKey
         * */

        //操作的数据 必须是能序列化
        //序列化技术 实现这个操作 apache lang3
        String key = "name";
        byte[] k = SerializationUtils.serialize(key);

        byte[] v = jedis.get(k);

        List<User> value = SerializationUtils.deserialize(v);

        System.out.println(value);


    }

}
