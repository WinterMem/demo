package com.pch.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 */
@Data
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -3588681970139736184L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 电话号码
     */
    private String tellPhone;
}