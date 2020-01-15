package com.pch.user.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
@Accessors(chain = true)
public class OAuth2RefreshTokenDO implements Serializable {

    private static final long serialVersionUID = 6900465040573021492L;

    /**
     * 刷新令牌
     */
    private String id;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 是否有效
     */
    private Boolean valid;
    /**
     * 过期时间
     */
    private Date expiresTime;
}
