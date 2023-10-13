package com.ph.share.hystrix.activity.api;

public interface ILoginActivityService {
    String firstLogin(Long userId);

    String firstLoginTimeout(Long userId);

    String firstLoginError(Long userId);
}
