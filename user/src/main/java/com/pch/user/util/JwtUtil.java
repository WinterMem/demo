package com.pch.user.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: pch
 *
 */
public class JwtUtil {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


}
