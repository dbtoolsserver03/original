package com.ph.share.share.validator.enums;

public enum  ErrorCode {
    SYSTEM_ERROR("0000","系统异常"),
    PARAM_ERROR("1000","参数不正确");


    private String code;
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
