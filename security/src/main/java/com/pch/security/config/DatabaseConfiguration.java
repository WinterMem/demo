package com.pch.security.config;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 扫描对应的 Mapper 接口
 */
@Component
@EnableTransactionManagement(proxyTargetClass = true)
public class DatabaseConfiguration {


}
