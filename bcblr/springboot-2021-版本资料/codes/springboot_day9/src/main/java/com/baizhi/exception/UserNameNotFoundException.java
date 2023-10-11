package com.baizhi.exception;

//自定义 用户名不存在异常
public class UserNameNotFoundException  extends RuntimeException{

    public UserNameNotFoundException(String message) {
        super(message);
    }
}
