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

public class MyMybatisInterceptor3 extends MyMybatisInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(MyMybatisInterceptor3.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        if (log.isDebugEnabled())
            log.debug("-----this is myMybatisInterceptor3-------");

        MetaObject metaObject = SystemMetaObject.forObject(invocation);

        String methodName = (String) metaObject.getValue("method.name");
        String sql = (String) metaObject.getValue("target.delegate.boundSql.sql");

        if (log.isDebugEnabled())
            log.debug("methodname is " + methodName + " sql is " + sql);

        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
