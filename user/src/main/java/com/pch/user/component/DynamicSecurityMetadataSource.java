package com.pch.user.component;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityMetadataSource;

/**
 * @Author: pch
 */
public class DynamicSecurityMetadataSource implements SecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
