package com.baizhiedu.plugins;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class LockInterceptor extends MyMybatisInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(LockInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (log.isInfoEnabled())
            log.info("----LockInterceptor------");

        MetaObject metaObject = SystemMetaObject.forObject(invocation);

        String sql = (String) metaObject.getValue("target.delegate.boundSql.sql");
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("target.delegate.mappedStatement");
        String id = mappedStatement.getId();

        /*
            在用户进行插入操作时，需要由拦截器 设置vers值0
            🤔 用户书写的Sql语句：insert into t_user (name) values (#{name});
               封装需要干的事    insert into t_user (name,vers) values (#{name},0)

               问题：如何获得 用户书写SQL ?
               解答：String sql = (String) metaObject.getValue("target.delegate.boundSql.sql");

               问题：如何修改sql语句 为其添加vers 值0 ？
               解决：涉及到对原有sql语句操作，JsqlParser

         */
        if (id.indexOf("save") != -1) {
            CCJSqlParserManager parserManager = new CCJSqlParserManager();
            Insert insert = (Insert) parserManager.parse(new StringReader(sql));
            //插入的列 vers  匹配对应的值 0
            //列名字 Columns
            List<Column> columns = insert.getColumns();
            columns.add(new Column("vers"));

            //列的值
            ExpressionList itemsList = (ExpressionList) insert.getItemsList();
            List<Expression> expressions = itemsList.getExpressions();
            expressions.add(new LongValue(0));
            insert.setSetExpressionList(expressions);

            //修改完成sql语句后 新的sql语句 交给Mybatis ---> 继续进行？替换
            metaObject.setValue("target.delegate.boundSql.sql", insert.toString());


        }

         /*
             update t_user set name =?,vers = vers+1 where id = ?
             如果进行update操作：
                1. 在提交update操作时，需要对比此时 对象中的version里面存储的值与数据库中vers字段中的值是否相等
                 1.1 如果不等
                       说明已经有其他用户进行了更新 （存在并发） 抛出异常
                 1.2 如果相等
                       可以进行更新操作，并把对应的vers+1

          */

        if (id.indexOf("update") != -1) {

            CCJSqlParserManager parserManager = new CCJSqlParserManager();
            Update update = (Update) parserManager.parse(new StringReader(sql));
            Table table = update.getTable();
            String tableName = table.getName();

            //id值 一定是更新操作中 User id属性存储

            Integer objectId = (Integer) metaObject.getValue("target.delegate.parameterHandler.parameterObject.id");
            Integer version = (Integer) metaObject.getValue("target.delegate.parameterHandler.parameterObject.version");

            Connection conn = (Connection) invocation.getArgs()[0];
            String selectSql = "select vers from " + tableName + " where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, objectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            int vers = 0;
            if (resultSet.next()) {
                vers = resultSet.getInt(1);
            }

            System.out.println();

            if (version.intValue() != vers) {
                throw new RuntimeException("版本不一致");
            } else {
                //vers+1
                //正常进行数据库更新
                List<Column> columns = update.getColumns();
                columns.add(new Column("vers"));

                List<Expression> expressions = update.getExpressions();
                expressions.add(new LongValue(vers + 1));
                update.setExpressions(expressions);

                metaObject.setValue("target.delegate.boundSql.sql", update.toString());
            }


        }
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
