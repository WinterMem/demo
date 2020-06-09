package com.pch.user.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -7327749889983711127L;

    /**
     * 成功返回编码
     */
    private static final Integer SUCCESS_CODE = 0;

    private Integer code;

    private String message;

    private T data;

    /**
     * 成功返回结果
     *
     */
    public static<T> CommonResult<T> success(T data) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setCode(SUCCESS_CODE);
        commonResult.setData(data);
        return commonResult;
    }

    /**
     * 失败返回结果
     *
     */
    public static<T> CommonResult<T> fail(Integer code, String message) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setData(null);
        return commonResult;
    }

    /**
     * 未登录返回信息
     *
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase(), data);
    }
}
