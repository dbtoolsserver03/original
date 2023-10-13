package com.ph.share.share.validator.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ph.share.share.validator.enums.ErrorCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO {
    /**
     * 后端是否处理成功
     */
    private boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误消息
     */
    private String msg;
    /**
     * 给前端的返回值
     */
    private Object data;

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        return resultVO;
    }

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(ErrorCode errorCode) {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(false);
        resultVO.setCode(errorCode.getCode());
        resultVO.setMsg(errorCode.getMsg());
        return resultVO;
    }

    public static ResultVO fail(ErrorCode errorCode, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(false);
        resultVO.setCode(errorCode.getCode());
        resultVO.setMsg(errorCode.getMsg());
        resultVO.setData(data);
        return resultVO;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
