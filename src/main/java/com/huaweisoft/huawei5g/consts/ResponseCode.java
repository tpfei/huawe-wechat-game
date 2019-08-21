package com.huaweisoft.huawei5g.consts;

/**
 * Created by Administrator on 2019/8/14.
 */
public enum ResponseCode {

    SUCCESS(1, "操作成功"),
    ERROR(0, "操作失败");

    private int code;
    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
