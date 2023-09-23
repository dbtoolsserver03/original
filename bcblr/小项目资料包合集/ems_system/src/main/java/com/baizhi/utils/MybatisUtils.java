package com.baizhi.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * mybatis的工具类
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 通过静态代码块优化现有工具类   静态代码块: 类加载时候执行 只执行一次  jvm ====> .class
     */
    static {
        InputStream is = null;
        try {
            //1.读取配置文件
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建sqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();//关流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 提供sqlSession的方法  推荐使用
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }



}
