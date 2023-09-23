package com.baizhi.results;

public class Result {
    private Boolean status;
    private String msg;

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Result() {
    }

    public Result(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
