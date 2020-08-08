package com.pch.user.service;

import com.pch.user.dto.auth.OAuth2CreateTokenDTO;
import com.pch.user.po.oauth2.OAuth2AccessTokenPo;

/**
 * OAuth 接口
 */
public interface OAuth2Service {

	/**
	 * 根据用户信息创建token
	 *
	 * @param oauth2CreateTokenDTO 用户信息
	 * @return refreshToken
	 */
	OAuth2AccessTokenPo createToken(OAuth2CreateTokenDTO oauth2CreateTokenDTO);

}
