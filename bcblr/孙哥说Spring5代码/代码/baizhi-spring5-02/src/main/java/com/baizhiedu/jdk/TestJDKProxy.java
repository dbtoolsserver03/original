package com.baizhiedu.jdk;

import com.baizhiedu.proxy.User;
import com.baizhiedu.proxy.a.UserService;
import com.baizhiedu.proxy.a.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {

    /*
        1. 借用类加载器  TestJDKProxy
                       UserServiceImpl
        2. JDK8.x前

            final UserService userService = new UserServiceImpl();
     */
    public static void main(String[] args) {
        //1 创建原始对象
        UserService userService = new UserServiceImpl();

        //2 JDK创建动态代理
        /*

         */

        InvocationHandler handler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("------proxy  log --------");
                //原始方法运行
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };

        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),userService.getClass().getInterfaces(),handler);

        userServiceProxy.login("suns", "123456");
        userServiceProxy.register(new User());

    }
}
