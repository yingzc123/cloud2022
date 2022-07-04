package com.yzc.cloud.advice;





import com.yzc.cloud.result.ResultCode;
import com.yzc.cloud.result.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


/**
 * SanZ
 * 全局拦截异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 拦截 全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultObject error(Exception e) {
        e.printStackTrace();
        return ResultObject.error().message(e.getMessage());
    }

    /**
     * 拦截 算数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResultObject error(ArithmeticException e) {
        e.printStackTrace();
        return ResultObject.error().message(e.getMessage());
    }

 /*   *//**
     * 拦截 自定义异常
     *
     * @param e
     * @return
     *//*
    @ExceptionHandler(LFLException.class)
    public ResultObject error(LFLException e) {
        e.printStackTrace();
        return ResultObject.error().code(e.getCode()).message(e.getMsg());
    }*/



    @ExceptionHandler(ConstraintViolationException.class)
    public ResultObject<String> error(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage).toList().get(0);
        return ResultObject.error(ResultCode.FAILED.getCode(), message);

    }


}
