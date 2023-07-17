package com.baizhi.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by HIAPAD on 2019/11/13.
 */
public class TestRedisString {

    private Jedis jedis;
    
    @Before
    public void before(){
        jedis = new Jedis("192.168.220.3", 7000);
    }

    @Test
    public void testKeys(){

        /*String set = jedis.set("name", "zhangsan");
        String name = jedis.get("name");
        System.out.println(name);
        String code = jedis.setex("code", 10, "2345");*/

        String hget = jedis.hget("maps", "name");
        System.out.println(hget);


    }

    @After
    public void after(){
        jedis.close();
    }
}
