package com.pch.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.pch.common.constant.AdminConstant;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(AdminConstant.WEBSOCKET_ENDPOINT)
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 配置spring mvc 简单broker
        registry.enableSimpleBroker(AdminConstant.ENABLE_BROKER_QUEUE,
                AdminConstant.ENABLE_BROKER_TOPIC);

//        registry.enableStompBrokerRelay("/topic", "/queue")
//            .

        //客户端向服务端发送前缀
        registry.setApplicationDestinationPrefixes(AdminConstant.CLIENT_TO_SERVER);
        //客服端一对一发送
        registry.setUserDestinationPrefix(AdminConstant.CLIENT_TO_CLIENT);

        //使用线程池处理
        registry.configureBrokerChannel().taskExecutor();

    }
}
