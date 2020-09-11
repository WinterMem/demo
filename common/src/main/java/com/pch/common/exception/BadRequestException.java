package com.pch.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author: pch
 * @date: 2020/9/11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends RuntimeException{

    private static final long serialVersionUID = -2550055596501377450L;

    private Long code;

    private String msg;

    public BadRequestException(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
