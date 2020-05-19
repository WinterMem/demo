package com.pch.user.task;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pch.user.constant.WebSocketConstant;

/**
 * @Author: pch
 * @Description: 服务器向客服端发送信息
 * @Date: Created in 16:08 2020/5/12
 * @Modified By:
 */
@Slf4j
@Component
public class ServerTask {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 1000)
    public void serverSendMsgToClient() {
        log.info("【推送消息】开始执行：{}", simpleDateFormat.format(new Date()));
        simpMessagingTemplate.convertAndSend(WebSocketConstant.ENABLE_BROKER_TOPIC + "getMsg", "服务器已经发送消息");
        log.info("【推送消息】执行结束：{}", simpleDateFormat.format(new Date()));

    }

    @Scheduled(fixedRate = 1000)
    public void writeMsg() {
        log.error("启动了");
    }
}
