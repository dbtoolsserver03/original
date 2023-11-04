package com.baizhiedu.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyMybatisInterceptor2 extends MyMybatisInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(MyMybatisInterceptor2.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //RoutingStatementHandler---delegate---
//        RoutingStatementHandler satementHandler = (RoutingStatementHandler) invocation.getTarget();
//        BoundSql boundSql = satementHandler.getBoundSql();
//        String sql = boundSql.getSql();


        MetaObject metaObject = SystemMetaObject.forObject(invocation);
        String sql = (String) metaObject.getValue("target.delegate.boundSql.sql");
        if (log.isDebugEnabled())
            log.debug("sql : " + sql);

        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
