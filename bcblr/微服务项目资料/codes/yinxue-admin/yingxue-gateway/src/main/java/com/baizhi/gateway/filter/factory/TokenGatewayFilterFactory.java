package com.baizhi.gateway.filter.factory;

import com.baizhi.constants.RedisPrefix;
import com.baizhi.exceptions.IllegalTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

//自定义token工厂
@Component  //代表在工厂中创建对象   @configuration 配置     @Component  在工厂中创建对象   使用 filtes -Token
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    private static final Logger log = LoggerFactory.getLogger(TokenGatewayFilterFactory.class);

    private RedisTemplate redisTemplate;

    @Autowired
    public TokenGatewayFilterFactory(RedisTemplate redisTemplate) {
        super(Config.class);
        this.redisTemplate = redisTemplate;
    }

    //Config 参数就是基于当前中Config创建对象
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {    // servlet service httpServletRequest  httpServletResponse 传统web springmvc   springwebflux new web模型 //filter   request response filterChain.dofilter(request,response)
            @Override
            //参数1: exchange 交换机
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("config required token: {}", config.requiredToken);
                log.info("config name: {}", config.name);
                if (config.requiredToken) {
                    //1.获取token信息
                    if (exchange.getRequest().getQueryParams().get("token") == null)
                        throw new IllegalTokenException("非法令牌!");
                    String token = exchange.getRequest().getQueryParams().get("token").get(0);
                    log.info("token:{}", token);
                    //2.根据token信息去redis获取
                    if (!redisTemplate.hasKey(RedisPrefix.TOKEN_KEY + token))
                        throw new IllegalTokenException("不合法的令牌!");
                }
                return chain.filter(exchange);
            }
        };
    }


    //用来配置将使用filter时指定值赋值给Config中哪个属性
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("requiredToken", "name");
    }


    //自定义配置类
    public static class Config {
        private boolean requiredToken;  //false
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isRequiredToken() {
            return requiredToken;
        }

        public void setRequiredToken(boolean requiredToken) {
            this.requiredToken = requiredToken;
        }
    }


}
