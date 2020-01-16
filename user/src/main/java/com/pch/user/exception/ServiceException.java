package com.pch.user.exception;

/**
 * 服务类异常处理
 */
public final class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 820763453066753527L;

    /**
     * 错误编码
     */
    private Integer code;

    public ServiceException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
