package com.baizhi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionResolver {


    //处理指定异常
    @ExceptionHandler(value = IllegalNumberException.class)
    @ResponseBody
    public ResponseEntity<String> illegalNumberExceptionHandler(Exception ex) {
        System.out.println("进入非法参数异常处理");
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //处理exception子类异常
    @ExceptionHandler(value = Exception.class) //用在方法上  作用:用来处理指定异常  value属性: 用来指定处理异常类型
    @ResponseBody
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        System.out.println("进入自定义异常处理");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
