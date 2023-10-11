package com.baizhi.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//传统前后端不分离异常处理  implements  HandlerExceptionResolver
//前分段分离之后异常处理
//@Component
public class GlobalExceptionResvoler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return new ModelAndView("/xxx");
    }
}
