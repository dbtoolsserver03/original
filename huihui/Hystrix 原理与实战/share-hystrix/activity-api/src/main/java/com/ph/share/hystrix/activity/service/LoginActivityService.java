package com.ph.share.hystrix.activity.service;

import com.ph.share.hystrix.activity.api.ILoginActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.ph.share.hystrix.activity.constant.ActivityServiceURL.*;

@Service
@ConditionalOnBean(RestTemplate.class)
public class LoginActivityService implements ILoginActivityService {
    @Autowired
    private RestTemplate restTemplate;


    public String firstLogin(Long userId) {
        return restTemplate.postForObject(PREFIX + FIRST_LOGIN_ACTIVITY, userId, String.class);
    }


    public String firstLoginTimeout(Long userId) {
        return restTemplate.postForObject(PREFIX + FIRST_LOGIN_ACTIVITY_TIMEOUT, userId, String.class);
    }


    public String firstLoginError(Long userId) {
        return restTemplate.postForObject(PREFIX + FIRST_LOGIN_ACTIVITY_ERROR, userId, String.class);
    }

}
