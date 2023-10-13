package com.ph.share.hystrix.user.feign;

import com.ph.share.hystrix.activity.feign.IFeignActivityService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "activity"
/*,fallback = FeignActivityServiceFallBack.class*/
        ,fallbackFactory = FeignActivityServiceFallBackFactory.class)
public interface FeignActivityServiceClient extends IFeignActivityService {
}
