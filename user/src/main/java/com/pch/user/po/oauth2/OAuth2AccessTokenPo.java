package com.pch.user.po.oauth2;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OAuth2AccessTokenPo implements Serializable {

	private static final long serialVersionUID = 7498482891757847887L;

	/**
	 * 访问令牌
	 */
	private String id;

	/**
	 * 刷新令牌
	 */
	private String refreshToken;

	/**
	 * 用户编号
	 */
	private Integer userId;

	/**
	 * 用户类型
	 */
	private Integer userType;

	/**
	 * 过期时间
	 */
	private Date expiresTime;

	/**
	 * 是否有效
	 */
	private Boolean valid;

}
