package com.ph.share.hystrix.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ph.share.hystrix.activity.constant.ActivityServiceURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ActivityServiceBulkhead {
    @Autowired
    private RestTemplate restTemplate;


    /**
     * 调用活动服务 完成初次登录 奖励发放
     *
     * @param userId
     * @return
     */
    public String firstLogin(Long userId) {
        return restTemplate.postForObject(ActivityServiceURL.PREFIX + ActivityServiceURL.FIRST_LOGIN_ACTIVITY, userId, String.class);
    }

    /**
     * 定义超时时间，让用户服务 不再等待 活动服务的响应
     * 这样的话，可以及时释放资源
     * HystrixThreadPoolProperties $ Setter （可以进去找配置）
     *
     * @param userId
     * @return
     */
    @HystrixCommand(
            threadPoolKey = "firstLoginTimeout",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "20")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")  //超时时间为 2秒
            }
    )
    public String firstLoginTimeout(Long userId) {
        return restTemplate.postForObject(ActivityServiceURL.PREFIX + ActivityServiceURL.FIRST_LOGIN_ACTIVITY_TIMEOUT, userId, String.class);
    }


    /**
     * 需要提供一个 备用方案，当活动服务不可用的时候，执行备用方案
     *
     * @param userId
     * @return
     */
    @HystrixCommand(
            threadPoolKey = "firstLoginFallback",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "20")
            },
            fallbackMethod = "firstLoginFallback0"
    ) // 降级方案是 firstLoginFallback0
    public String firstLoginFallback(Long userId) {
        return restTemplate.postForObject(ActivityServiceURL.PREFIX + ActivityServiceURL.FIRST_LOGIN_ACTIVITY_ERROR, userId, String.class);
    }

    public String firstLoginFallback0(Long userId) {
        return "活动备用方案";
    }


    /**
     * 3秒钟内，请求次数达到 2 个，并且失败率在 50%以上，就跳闸
     * 跳闸后的活动窗口设置为 3 秒
     *
     * @param userId
     * @return
     */
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "3000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")
            }
    )
    public String firstLoginCircuitOpen(Long userId) {
        return restTemplate.postForObject(ActivityServiceURL.PREFIX + ActivityServiceURL.FIRST_LOGIN_ACTIVITY_ERROR, userId, String.class);
    }
}
