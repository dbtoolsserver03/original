package com.baizhi.config;

import com.baizhi.interceptors.MyInterceptor1;
import com.baizhi.interceptors.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    /**
     * 配置拦截器相关方法
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {




        registry.addInterceptor(new MyInterceptor1()) //指定拦截器
                .addPathPatterns("/**")//拦截所有
                .excludePathPatterns("/file/**")//排除那些路径
                .order(1);//指定拦截器执行顺序 int 类型数字: 默认按照自然排序执行  数字相同时,按照配置顺序执行



        registry.addInterceptor(new MyInterceptor2())
                .addPathPatterns("/login","/user")
                .excludePathPatterns("/file/**")
                .order(2);







        //1 4 5 2 6 3

        //4 1 2 5 3 6
    }
}
