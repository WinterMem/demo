package com.pch.user.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pch.user.common.CommonResult;

/**
 * @Author: pch
 */
@ControllerAdvice
@Slf4j
public class GlobalValidateExceptionHandler {

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public CommonResult<Boolean> BindExceptionHandler(BindException e) {
        String message = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());
        return CommonResult.failed(10000L, message);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public CommonResult<Boolean> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining());
        return CommonResult.failed(10001L, message);
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult<Boolean> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());
        return CommonResult.failed(10003L, message);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public CommonResult<Boolean> ServiceExceptionHandler(ServiceException e) {
        return CommonResult.failed(e.getCode(), e.getMessage());
    }

//    @ExceptionHandler(UsernameNotFoundException.class)
//    @ResponseBody
//    public CommonResult UsernameNotFoundExceptionHandler(UsernameNotFoundException e) {
//        String message = e.getMessage();
//        return CommonResult.fail(10004, message);
//    }
}
