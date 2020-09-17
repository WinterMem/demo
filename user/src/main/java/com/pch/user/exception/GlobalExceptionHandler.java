package com.pch.user.exception;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pch.common.exception.ServiceException;
import com.pch.common.response.CommonResult;

/**
 * @author: pch
 * @date: 2020/9/8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public CommonResult<Boolean> BindExceptionHandler(BindException e) {
        String message = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(",", "", ""));
        return CommonResult.validateFailed(message);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResult<Boolean> ConstraintViolationExceptionHandler(
            ConstraintViolationException e) {
        String message = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(",", "", ""));
        return CommonResult.validateFailed(message);
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<Boolean> MethodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(",", "", ""));
        return CommonResult.validateFailed(message);
    }

    /**
     * 处理业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public CommonResult<Boolean> ServiceExceptionHandler(ServiceException e) {
        return CommonResult.failed(e.getCode(), e.getMessage());
    }

    /**
     * 其他异常管理
     *
     */
    @ExceptionHandler(Exception.class)
    public CommonResult<Boolean> ExceptionHandler(Exception e) {
        e.printStackTrace();
        return CommonResult.failed(e.getMessage());
    }

}
