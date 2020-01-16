package com.pch.user.common;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -7327749889983711127L;

    private static final Integer SUCCESS_CODE = 0;

    private Integer code;

    private String message;

    private T data;

    /**
     * 成功返回结果
     *
     * @param data
     * @param <T>
     * @return
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
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static<T> CommonResult<T> fail(Integer code, String message) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setData(null);
        return commonResult;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
