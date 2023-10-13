package com.ph.share.hystrix.activity.controller;


import com.ph.share.hystrix.activity.api.ILoginActivityService;
import com.ph.share.hystrix.activity.constant.ActivityServiceURL;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 处理 注册、登录 相关活动
 */
@RestController
public class LoginActivityController implements ILoginActivityService {


    @PostMapping(ActivityServiceURL.FIRST_LOGIN_ACTIVITY)
    public String firstLogin(@RequestBody Long userId) {
        System.out.println("LoginActivityController 为首次登录（注册）用户发放优惠券成功" + userId);
        return "succ";
    }


    /**
     * 模拟 出现性能问题，响应时间很长
     * @param userId
     * @return
     */
    @PostMapping(ActivityServiceURL.FIRST_LOGIN_ACTIVITY_TIMEOUT)
    public String firstLoginTimeout(@RequestBody Long userId) {
        try {
            TimeUnit.SECONDS.sleep(RandomUtils.nextInt(5)+1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("LoginActivityController 为首次登录（注册）用户发放优惠券成功" + userId);
        return "succ";
    }


    /**
     * 模拟 活动服务 不可用
     * @param userId
     * @return
     */
    @PostMapping(ActivityServiceURL.FIRST_LOGIN_ACTIVITY_ERROR)
    public String firstLoginError(@RequestBody Long userId) {
        throw new RuntimeException("LoginActivityController 为首次登录（注册）用户发放优惠券失败" + userId);
//        return "succ";
    }

}
