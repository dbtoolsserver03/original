package com.baizhiedu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {
   private static JedisPool jedisPool = null;
   private static Properties properties = new Properties();

   static{
       InputStream inputStream = null;
       try {
           inputStream = JedisUtils.class.getResourceAsStream("/redisCache.properties");
           properties.load(inputStream);
       } catch (IOException e) {
           e.printStackTrace();
       }finally{
           if (inputStream != null) {
               try {
                   inputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       JedisPoolConfig jedisPoolConfig  = new JedisPoolConfig();
       jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
       jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
       jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(properties.getProperty("maxWait")));

       jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("ip"),Integer.parseInt(properties.getProperty("port")));
   }

    public static Jedis getJedis() {
       return jedisPool.getResource();
    }

    public static void close(Jedis jedis){
       jedis.close();
    }

}
