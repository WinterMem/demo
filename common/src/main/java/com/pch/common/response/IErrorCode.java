package com.pch.common.response;

/**
 * 封装API的错误码
 */
public interface IErrorCode {

    Long getCode();

    String getMessage();
}
