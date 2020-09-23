package com.pch.common.constant;

/**
 * 常量
 *
 * @author: pch
 * @date: 2020/9/17
 */
public interface AdminConstant {

    /** token 命名前缀 */
    String REDIS_TOKEN_SPACE = "pch_token:";
    
    /** webSocket 常量 */
    String WEBSOCKET_ENDPOINT = "/endpoint";
    String ENABLE_BROKER_TOPIC = "/topic";
    String ENABLE_BROKER_QUEUE = "/queue";
    String CLIENT_TO_SERVER = "/app";
    String CLIENT_TO_CLIENT = ENABLE_BROKER_TOPIC + "/user";

}
