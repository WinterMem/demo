package com.pch.common.config;

import cn.hutool.core.util.IdUtil;

/**
 * 使用雪花算法生成自增id
 * @author: pch
 * @date: 2020/9/17
 */
public class IdSnowflake {

    private static final Long workId = 0L;

    private static final Long datacenterId = 0L;

    public static Long nextId() {
        return IdUtil.createSnowflake(workId, datacenterId).nextId();
    }

}
