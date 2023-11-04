package com.baizhiedu.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Intercepts({
        @Signature(type= Executor.class,method="query",args={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type= Executor.class,method="update",args={MappedStatement.class,Object.class})
})
public class MyMybatisInterceptor implements Interceptor {
    private String test;
    private static final Logger log = LoggerFactory.getLogger(MyMybatisInterceptor.class);

    @Override
    /**
     *  作用：执行的拦截功能 书写在这个方法中.
     *       放行
     */
    public Object intercept(Invocation invocation) throws Throwable {
        if (log.isDebugEnabled())
            log.debug("----拦截器中的 intercept 方法执行------  "+test);
        return invocation.proceed();
    }

    /*
     *  把这个拦截器目标 传递给 下一个拦截器
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    /*
     *  获取拦截器相关参数的
     */
    @Override
    public void setProperties(Properties properties) {
       this.test = properties.getProperty("test");
    }
}
