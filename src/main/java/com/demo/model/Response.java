package com.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 接口响应
 */
@ApiModel(value = "响应Response", description = "接口响应信息")
public class Response {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码", name = "code", example = "100")
    private String code;

    /**
     * 状态码描述
     */
    @ApiModelProperty(value = "状态码描述", name = "message", example = "成功")
    private String message;

    /**
     * 接口异常信息
     */
    @ApiModelProperty(value = "接口异常信息", name = "error", example = "更新对象不存在")
    private String error;

    /**
     * 结果信息
     */
    @ApiModelProperty(value = "结果信息", name = "result", example = "{}")
    private Object result;

    public Response() {
        this.code = ApiCode.SUCCESS.getCode();
        this.message = ApiCode.SUCCESS.getMessage();
    }

    public Response(Object result) {
        this.code = ApiCode.SUCCESS.getCode();
        this.message = ApiCode.SUCCESS.getMessage();
        this.result = result;
    }

    public Response(ApiCode apiCode, String error) {
        this.code = apiCode.getCode();
        this.message = apiCode.getMessage();
        this.error = error;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
