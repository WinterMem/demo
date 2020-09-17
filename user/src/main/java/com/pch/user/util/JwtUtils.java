package com.pch.user.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import com.pch.common.config.IdSnowflake;
import com.pch.common.constant.SpaceConstant;
import com.pch.user.service.RedisService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: pch
 * @date: 2020/9/9
 */
@Slf4j
public class JwtUtils implements Serializable {

    private static final long serialVersionUID = -2871409030618576906L;

    private static final String CLAIM_KEY_USERNAME = "sub";

    private static final String CLAIM_KEY_CREATED = "created";

    public static final String CLAIM_KEY_TOKEN_ID = "tokenId";

    @Autowired
    private RedisService redisService;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${jwt.iss}")
    private String iss;

    /**
     * 根据负载生成JWT的token
     *
     * @param claims 负载信息
     * @return token
     */
    public String generateToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setIssuer(iss)
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        redisService.set(SpaceConstant.REDIS_TOKEN_SPACE + claims.get(CLAIM_KEY_TOKEN_ID),
                token, 1000 * 60 * 60);
        return token;
    }

    /**
     * 从token中获取JWT中的负载
     *
     * @param token 客服端传入token
     * @return jwt负载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            JwtUtils.log.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    /**
     * 从token中获取用户名
     *
     * @param token 客服端传入token
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 根据userDetails获取token
     *
     * @param userDetails 从数据库中查询出来的用户信息
     * @return token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        String tokenId = IdSnowflake.nextId().toString();
        claims.put(JwtUtils.CLAIM_KEY_CREATED, new Date());
        claims.put(JwtUtils.CLAIM_KEY_TOKEN_ID, tokenId);
        claims.put(JwtUtils.CLAIM_KEY_USERNAME, userDetails.getUsername());
        return generateToken(claims);
    }

    /**
     * 验证token是否有效
     *
     * @param token       客服端传来的token
     * @param userDetails 从数据库中查询出来的用户信息
     * @return true       失效
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        Claims claimsFromToken = getClaimsFromToken(token);
        String cacheToken = redisService
                .get(SpaceConstant.REDIS_TOKEN_SPACE + claimsFromToken.get(CLAIM_KEY_TOKEN_ID))
                .toString();
        if (null == cacheToken) {
            return false;
        }
        return claimsFromToken.getSubject().equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    /**
     * 原来的token没过期时是可以刷新的
     *
     * @param oldToken 带有tokenHead的token
     */
    public String refreshToken(String oldToken) {
        if (StrUtil.isEmpty(oldToken)) {
            return null;
        }
        String token = oldToken.substring(tokenHead.length());
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        Claims claims = getClaimsFromToken(token);
        if (null == claims) {
            return null;
        }
        // 判断token是否过期
        if (isTokenExpired(token)) {
            return null;
        }
        if (tokenRefreshJustBefore(token, 30 * 60)) {
            return token;
        } else {
            claims.put(JwtUtils.CLAIM_KEY_CREATED, new Date());
            return generateToken(claims);
        }
    }

    /**
     * @param token 源token
     * @param time  有效时间
     */
    private boolean tokenRefreshJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(JwtUtils.CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        return refreshDate.after(created)
                && refreshDate.before(DateUtil.offsetSecond(created, time));
    }

    /**
     * 判断token是否失效
     *
     * @param token 客户端传入token
     * @return true 失效
     */
    public boolean isTokenExpired(String token) {
        Date expirationDate = generateClaimsFormToken(token);
        return expirationDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     *
     * @param token 客户端传入token
     */
    private Date generateClaimsFormToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 生成token过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
}
