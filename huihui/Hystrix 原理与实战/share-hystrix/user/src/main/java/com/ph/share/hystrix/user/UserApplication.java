package com.ph.share.hystrix.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableHystrix
//@EnableCircuitBreaker

/**
 * SpringCloudApplication
 *  提供了 spring boot 的功能
 *  提供了自动注册到服务中心的功能
 *  开启了断路器
 */
@SpringCloudApplication
@EnableFeignClients
public class UserApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public LoginActivityService loginActivityService() {
//        return new LoginActivityService();
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
