package com.pch.user.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 */
@Data
@Accessors(chain = true)
@TableName("tb_user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = -8692760072307721060L;

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * tell
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

//    /**
//     * 金钱
//     */
//    private float money;
}
