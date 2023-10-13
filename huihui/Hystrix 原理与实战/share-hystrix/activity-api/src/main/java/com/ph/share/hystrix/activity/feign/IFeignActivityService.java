package com.ph.share.hystrix.activity.feign;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface IFeignActivityService {

    @PostMapping("/firstLoginActivity")
    String firstLogin(@RequestBody Long userId);

    @PostMapping("/firstLoginActivityTimeout")
    String firstLoginTimeout(@RequestBody Long userId);

    @PostMapping("/firstLoginActivityError")
    String firstLoginError(@RequestBody Long userId);

}
