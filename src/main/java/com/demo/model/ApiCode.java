package com.demo.model;

/**
 * 接口状态码
 */
public enum ApiCode {

    SUCCESS("100", "成功"),
    FORBIDDEN("200", "请求拒绝"),
    FAILURE("300", "失败");

    private String code;
    private String message;

    ApiCode() {
    }

    ApiCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
