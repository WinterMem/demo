package com.pch.security.component;

import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

/**
 * @Author: pch
 */
public interface DynamicSecurityService {

    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
