package com.pch.user.exception;

import com.pch.user.constant.SysState;
import lombok.Getter;
import lombok.Setter;

/**
 * 服务类异常处理
 */
@Getter
@Setter
public final class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 820763453066753527L;

    /**
     * 错误编码
     */
    private Long code;

    /**
     * 错误信息
     */
    private String message;

    public ServiceException(Long code, String message) {
        this.message = message;
        this.code = code;
    }

    public ServiceException(SysState sysState) {
        this.message = sysState.getError();
        this.code = sysState.getCode();
    }
}
