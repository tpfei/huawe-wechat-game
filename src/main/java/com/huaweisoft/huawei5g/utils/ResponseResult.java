package com.huaweisoft.huawei5g.utils;

import com.huaweisoft.huawei5g.consts.ResponseCode;

/**
 * Created by Administrator on 2019/8/14.
 */

public class ResponseResult<T> {

    private int code;

    private String msg;

    private T data;

    private long totalTime;

    private ResponseResult(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getDesc();
    }

    private ResponseResult(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getDesc();
        this.data = data;
    }

    private ResponseResult(ResponseCode responseCode, String msg) {
        this.code = responseCode.getCode();
        this.msg = msg;
    }

    private ResponseResult(ResponseCode responseCode, String msg, T data) {
        this.code = responseCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult success() {
        return new ResponseResult(ResponseCode.SUCCESS);
    }
    public static ResponseResult error() {
        return new ResponseResult(ResponseCode.ERROR);
    }
    public static ResponseResult build(ResponseCode responseCode) {
        return new ResponseResult(responseCode);
    }
    public static<T> ResponseResult<T> build(ResponseCode responseCode, T data) {
        return new ResponseResult(responseCode,data);
    }
    public static ResponseResult build(ResponseCode responseCode, String msg) {
        return new ResponseResult(responseCode,msg);
    }
    public static<T> ResponseResult<T> build(ResponseCode responseCode, String msg, T data) {
        return new ResponseResult(responseCode,msg,data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }
}

