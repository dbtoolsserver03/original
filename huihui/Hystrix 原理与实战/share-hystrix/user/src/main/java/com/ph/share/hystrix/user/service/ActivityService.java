package com.ph.share.hystrix.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {
    @Autowired
    private RestTemplate restTemplate;


    /**
     * 调用活动服务 完成初次登录 奖励发放
     * @param userId
     * @return
     */
    public String firstLogin(Long userId) {
        return restTemplate.postForObject("http://activity/firstLoginActivity", userId, String.class);
    }

    /**
     * 定义超时时间，让用户服务 不再等待 活动服务的响应
     * 这样的话，可以及时释放资源
     * HystrixCommandProperties （可以进去找配置）
     * @param userId
     * @return
     */
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")  //超时时间为 2秒
            }
    )
    public String firstLoginTimeout(Long userId) {
        return restTemplate.postForObject("http://activity/firstLoginActivityTimeout", userId, String.class);
    }


    /**
     * 需要提供一个 备用方案，当活动服务不可用的时候，执行备用方案
     * @param userId
     * @return
     */
    @HystrixCommand(fallbackMethod = "firstLoginFallback0") // 降级方案是 firstLoginFallback0
    public String firstLoginFallback(Long userId) {
        return restTemplate.postForObject("http://activity/firstLoginActivityError", userId, String.class);
    }

    public String firstLoginFallback0(Long userId) {
        return "活动备用方案";
    }
}
