package com.pch.user.component;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import cn.hutool.core.collection.CollUtil;

/**
 * @author: pch
 * @date: 2020/9/12
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object,
            Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        if (CollUtil.isEmpty(configAttributes)) {
            return;
        }
        for (ConfigAttribute configAttribute : configAttributes) {
            String needAttribute = configAttribute.getAttribute();
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (needAttribute.trim().equals(authority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("抱歉，您没有权限访问");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
