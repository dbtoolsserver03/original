package com.baizhiedu.plugins;

import com.baizhiedu.util.Page;
import com.baizhiedu.util.ThreadLocalUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class PageHelperInterceptor1 extends MyMybatisInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(PageHelperInterceptor1.class);

    private String queryMethodPrefix;

    private String queryMethodSuffix;

    private String databaseType;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (log.isInfoEnabled())
            log.info("----pageHelperInterceptor------");
        //获得sql语句 拼接字符串 limit
        MetaObject metaObject = SystemMetaObject.forObject(invocation);

        String sql = (String) metaObject.getValue("target.delegate.boundSql.sql");
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("target.delegate.mappedStatement");
        String id = mappedStatement.getId();

        if (id.indexOf(queryMethodPrefix) != -1 && id.endsWith(queryMethodSuffix)) {
            //分页相关的操作封装 对象（vo dto)
            //获得Page对象 并设置Page对象 totalSize属性 算出总页数

            //假设 Page
            //Page page = new Page(1);

            //直接通过DAO方法的参数 获得Page对象
            //Page page = (Page) metaObject.getValue("target.delegate.parameterHandler.parameterObject");

            //通过ThreadLocalUtils
            Page page = ThreadLocalUtils.get();
            //清空一下


            //select id,name from t_user 获得 全表有多少条数据
            // select count(*) from t_user

            //select id,name from t_user where name = ?;
            //select count(*）fromt t_user where name = ?

            //select id,name from t_user where  name = ? and id = ?;

            String countSql = "select count(*) " + sql.substring(sql.indexOf("from"));
            //JDBC操作
            //1 Connection  PreapredStatement
            Connection conn = (Connection) invocation.getArgs()[0];
            PreparedStatement preparedStatement = conn.prepareStatement(countSql);

           /* preparedStatement.setString(1,?)
            preparedStatement.setString(2,?);*/
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("target.delegate.parameterHandler");
            parameterHandler.setParameters(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
               page.setTotalSize(resultSet.getInt(1));
            }
            //page.setTotalSize();


            //做一个判断 如果当前是MySQL 如果是Oracle....
            //if databaseType == "oracle" or "mysql"
            String newSql = sql + " limit "+page.getFirstItem()+","+page.getPageCount();

            metaObject.setValue("target.delegate.boundSql.sql", newSql);
        }
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        this.queryMethodPrefix = properties.getProperty("queryMethodPrefix");
        this.queryMethodSuffix = properties.getProperty("queryMethodSuffix");
    }
}
