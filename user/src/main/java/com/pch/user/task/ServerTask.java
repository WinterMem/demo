package com.pch.user.task;

import com.pch.user.constant.WebSocketConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: pch
 * @Description: 服务器向客服端发送信息
 * @Date: Created in 16:08 2020/5/12
 * @Modified By:
 */
@Slf4j
@Component
public class ServerTask {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(cron = "0/2 * * * * ?")
    public void serverSendMsgToClient() {
        log.info("【推送消息】开始执行：{}", new Date());
        simpMessagingTemplate.convertAndSend(WebSocketConstant.ENABLE_BROKER_TOPIC + "getMsg", "服务器已经发送消息");
        log.info("【推送消息】执行结束：{}", new Date());

    }
}
