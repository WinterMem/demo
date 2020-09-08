package com.pch.user.model.dto.auth;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 */
@Data
@Accessors(chain = true)
public class OAuth2CreateTokenDTO implements Serializable {

    private static final long serialVersionUID = 1327723766187614279L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户类型
     */
    private String userType;
}
