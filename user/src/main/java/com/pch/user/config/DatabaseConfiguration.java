package com.pch.user.config;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *	扫描对应的 Mapper 接口
 */
@Component
@MapperScan({ "com.pch.user.dao", "com.baomidou.mybatisplus.samples.quickstart.mapper" })
@EnableTransactionManagement(proxyTargetClass = true)
public class DatabaseConfiguration {


}
