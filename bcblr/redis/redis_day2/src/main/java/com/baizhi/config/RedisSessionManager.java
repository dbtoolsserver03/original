package com.baizhi.config;

//会话管理机制

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 2000,redisNamespace = "redis:session") //开启redissession管理
public class RedisSessionManager {
}

