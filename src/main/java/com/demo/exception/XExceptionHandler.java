package com.demo.exception;

import com.demo.model.ApiCode;
import com.demo.model.Response;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class XExceptionHandler extends ExceptionHandlerExceptionResolver {

    @ExceptionHandler(Exception.class)
    public Response handler(Exception e) {
        if (e instanceof BindException) {
            BindingResult result = ((BindException) e).getBindingResult();
            return validatorCheck(result);
        } else if (e instanceof MethodArgumentNotValidException) {
            BindingResult result = ((MethodArgumentNotValidException) e).getBindingResult();
            return validatorCheck(result);
        } else if (e instanceof LogicException) {
            return new Response(ApiCode.FORBIDDEN, e.getMessage());
        }
        // 未拦截的异常
        e.printStackTrace();
        return new Response(ApiCode.FAILURE, e.getMessage());
    }

    /**
     * Hibernate Validator 错误信息拼装
     *
     * @param result
     * @return
     */
    public Response validatorCheck(BindingResult result) {
        StringBuffer buffer = new StringBuffer();
        for (ObjectError error : result.getAllErrors()) {
            buffer.append(error.getDefaultMessage()).append(",");
        }
        if (buffer.length() > 0) {
            buffer.delete(buffer.length() - 1, buffer.length());
        }
        return new Response(ApiCode.FORBIDDEN, buffer.toString());
    }
}
