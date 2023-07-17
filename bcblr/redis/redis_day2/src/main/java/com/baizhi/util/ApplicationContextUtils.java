package com.baizhi.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils  implements ApplicationContextAware{

    private static ApplicationContext context;

    @Override
    //参数1:已经创建好的工厂对象
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    //工具方法根据beanid获取对象
    public static Object  getBean(String id){
        return context.getBean(id);
    }

    //根据类型获取工厂中对象
    public static Object  getBean(Class clazz){
        return context.getBean(clazz);
    }
    //根据beanid 和 类型同时获取对象
    public static Object  getBean(String id,Class clazz){
        return context.getBean(id,clazz);
    }
}
