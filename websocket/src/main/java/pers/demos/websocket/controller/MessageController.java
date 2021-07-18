package pers.demos.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import pers.demos.websocket.entity.MessageBody;

/**
 * @author JustEP
 * @version 1.0
 * @date 2021/7/17 22:49
 */
@Controller
public class MessageController {

    /** 消息发送工具对象 */
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    public MessageController(SimpMessageSendingOperations simpMessageSendingOperations) {
        this.simpMessageSendingOperations = simpMessageSendingOperations;
    }

    /** 广播发送消息，将消息发送到指定的目标地址 */
    @MessageMapping("/test")
    public void sendTopicMessage(MessageBody messageBody) {
        // 将消息发送到 WebSocket 配置类中配置的代理中（/topic）进行消息转发
        simpMessageSendingOperations.convertAndSend(messageBody.getDestination(), messageBody);
    }

}
