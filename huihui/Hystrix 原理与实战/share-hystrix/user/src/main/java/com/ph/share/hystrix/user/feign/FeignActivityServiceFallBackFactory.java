package com.ph.share.hystrix.user.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 1、必须实现FallbackFactory 接口
 * 2、需要提供一个 被 @FeignClient 标注的接口 的实现
 * 3、必须是一个 spring bean
 */
@Component
public class FeignActivityServiceFallBackFactory implements FallbackFactory<FeignActivityServiceClient> {
    @Override
    public FeignActivityServiceClient create(Throwable throwable) {
        return new FeignActivityServiceClient() {
            @Override
            public String firstLogin(Long userId) {
                return "feign 执行降级 --5ms";
            }

            @Override
            public String firstLoginTimeout(Long userId) {
                return "feign 超时回退 factory " + throwable;
            }

            @Override
            public String firstLoginError(Long userId) {
                return null;
            }
        };
    }
}
