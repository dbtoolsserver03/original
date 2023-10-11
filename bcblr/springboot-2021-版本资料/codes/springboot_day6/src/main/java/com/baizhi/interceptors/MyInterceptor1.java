package com.baizhi.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器器
 */
public class MyInterceptor1 implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyInterceptor1.class);

    //pre handler 最先执行
    //参数3: handler 当前请求请求的控制器方法对象  DemoController#demo
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("handler: {} ", handler);
        log.debug("===========1=========");
        //response.sendRedirect(request.getContextPath()+"/403.jsp");
        return true;//放行 false 中断
    }

    //参数3: handler 当前请求请求的控制器方法对象  DemoController#demo
    //参数4: modelAndView 模型和视图  当前请求访问方法的modelandview对象
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("===========2=========");
        //log.debug("view: {}",modelAndView.getViewName());
    }

    //参数3: handler 当前请求请求的控制器方法对象  DemoController#demo
    //参数4: exception 如果控制器出现异常时异常对象
    //这个方法: finally{}代码块  总是执行  无论请求正确,出现异常
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("===========3=========");
    }
}
