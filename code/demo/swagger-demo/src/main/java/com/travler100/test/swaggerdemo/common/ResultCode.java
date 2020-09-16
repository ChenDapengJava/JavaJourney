package com.travler100.test.swaggerdemo.common;

/**
 * @program: demo
 * @description:
 * @author: 行百里者
 * @create: 2020/09/11 18:57
 **/
public enum ResultCode {

    SUCCESS(200, "操作成功！"),
    FAILED(500, "操作失败！");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
