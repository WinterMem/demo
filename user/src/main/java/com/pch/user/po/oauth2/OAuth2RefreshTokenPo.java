package com.pch.user.po.oauth2;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 刷新令牌
 */
@Data
@Accessors(chain = true)
public class OAuth2RefreshTokenPo implements Serializable {

	private static final long serialVersionUID = 6093429644488811870L;

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
