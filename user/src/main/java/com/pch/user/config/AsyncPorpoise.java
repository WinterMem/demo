package com.pch.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 异步配置属性
 * @author: pch
 * @date: 2020/9/23
 */
@Getter
@Setter
@ConfigurationProperties("task.pool")
public class AsyncPorpoise {

    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private int keepAliveSeconds;

}
