package com.ph.share.hystrix.user.feign;

import com.ph.share.hystrix.activity.feign.IFeignActivityService;
import org.springframework.stereotype.Component;

@Component
public class FeignActivityServiceFallBack implements IFeignActivityService {
    @Override
    public String firstLogin(Long userId) {
        return null;
    }

    @Override
    public String firstLoginTimeout(Long userId) {
        return "feign 超时回退";
    }

    @Override
    public String firstLoginError(Long userId) {
        return null;
    }
}
