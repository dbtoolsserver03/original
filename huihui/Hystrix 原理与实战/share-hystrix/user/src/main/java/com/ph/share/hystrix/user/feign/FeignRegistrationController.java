package com.ph.share.hystrix.user.feign;

import com.ph.share.hystrix.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册相关
 */
@RestController
@RequestMapping("/feign")
public class FeignRegistrationController {

    @Autowired
//    private FeignActivityService activityService;
//    private IFeignActivityService activityService;
    private FeignActivityServiceClient activityService;


    /**
     * 用户正常注册
     * http://localhost:8200/userRegistration
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
    @PostMapping("/userRegistrationFallback")
    public String userRegistrationFallback(@RequestBody User user) {
        System.out.println("用户的注册 成功 "+user.getName());
        return activityService.firstLoginError(user.getId());
    }


}
