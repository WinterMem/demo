package com.pch.user.constant;

/**
 * 换回异常类
 */
public enum SysState {

    upload_err(1000, "上传失败"),

    /*** user相关service错误编码 */
    user_exist(40000001, "改登录名已存在")
    ;

    private final int code;

    private final String message;

    private SysState(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return message;
    }

    public static SysState value(int code) {
        for (SysState e : values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }

    public static SysState value(String message) {
        for (SysState e : values()) {
            if (e.message.equals(message)) {
                return e;
            }
        }
        return null;
    }
}
