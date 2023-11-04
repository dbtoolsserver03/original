package com.baizhiedu.plugins;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Plugin;

public abstract class MyMybatisInterceptorAdapter implements Interceptor {
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

}
