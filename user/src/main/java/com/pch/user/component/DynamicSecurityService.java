package com.pch.user.component;

import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

/**
 * @author: pch
 * @date: 2020/9/12
 */
public interface DynamicSecurityService {

    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
