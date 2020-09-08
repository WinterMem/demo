package com.pch.common.constant;

public interface WebSocketConstant {

    String WEBSOCKET_ENDPOINT = "/endpoint";

    String ENABLE_BROKER_TOPIC = "/topic";

    String ENABLE_BROKER_QUEUE = "/queue";

    String CLIENT_TO_SERVER = "/app";

    String CLIENT_TO_CLIENT = ENABLE_BROKER_TOPIC + "/user";
}
