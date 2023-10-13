package com.ph.share.hystrix.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ph.share.hystrix.activity.api.ILoginActivityService;
import com.ph.share.hystrix.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册相关
 *
 * V2 里面直接调用 activity 提供的接口
 */
@RestController
@RequestMapping("/v2")
public class RegistrationControllerV2 {

    @Autowired
    private ILoginActivityService activityService;


    /**
     * 用户正常注册
     * http://localhost:8200/v2/userRegistration
     * @param user
     * @return
     */
    @PostMapping("/userRegistration")
    public String userRegistration(@RequestBody User user) {
        System.out.println("用户的注册 成功 "+user.getName());
        return activityService.firstLogin(user.getId());
    }

    /**
     * 活动服务存在性能问题，响应时间过长
     * @param user
     * @return
     */
    @PostMapping("/userRegistrationTimeout")
    public String userRegistrationTimeout(@RequestBody User user) {
        System.out.println("用户的注册 成功 "+user.getName());
        return activityService.firstLoginTimeout(user.getId());
    }

    /**
     * 需要提供一个 备用方案，当活动服务不可用的时候，执行备用方案
     * @param user
     * @return
     */
    @HystrixCommand(fallbackMethod = "firstLoginFallback0") // 降级方案是 firstLoginFallback0
    @PostMapping("/userRegistrationFallback")
    public String userRegistrationFallback(@RequestBody User user) {
        System.out.println("用户的注册 成功 "+user.getName());
        return activityService.firstLoginError(user.getId());
    }

    public String firstLoginFallback0(User user) {
        return "活动备用方案V2";
    }


}
