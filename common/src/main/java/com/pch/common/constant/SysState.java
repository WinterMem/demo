package com.pch.common.constant;

/**
 * 换回异常类
 */
public enum SysState {

    upload_err(1000L, "上传失败"),

    /*** user相关service错误编码 */
    user_exist(40000001L, "登录名已存在"),
    user_telephone_exist(40000002L, "手机号已存在"),
    user_email_exist(40000003L, "邮箱已存在"),
    user_id_not_exist(40000004L, "用户id不存在"),
    user_login_name_exist(40000005L, "用户登录名称已存在"),


    /**业务相关*/

    ;

    private final Long code;

    private final String message;

    SysState(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public String getError() {
        return message;
    }

    public static SysState value(int code) {
        for (SysState e : SysState.values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }

    public static SysState value(String message) {
        for (SysState e : SysState.values()) {
            if (e.message.equals(message)) {
                return e;
            }
        }
        return null;
    }
}
