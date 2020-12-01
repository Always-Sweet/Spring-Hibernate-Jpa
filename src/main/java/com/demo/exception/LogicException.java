package com.demo.exception;

import com.demo.model.ApiCode;

/**
 * 逻辑异常类
 */
public class LogicException extends Exception {

    public ApiCode code = ApiCode.FORBIDDEN;

    public LogicException(String message) {
        super(message);
    }
}
