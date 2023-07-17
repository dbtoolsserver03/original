package com.baizhi.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedisKeys {

    private Jedis jedis;
    
    @Before
    public void before(){
        jedis = new Jedis("192.168.220.3", 7000);
    }

    @Test
    public void testKeys(){

        //keys
        Set<String> keys = jedis.keys("*");
        keys.forEach(key-> System.out.println(key));

        //删除一个key
        Long del = jedis.del("n", "age");
        System.out.println(del);


    }

    @After
    public void after(){
        jedis.close();
    }
}
