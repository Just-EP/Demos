package pers.demos.websocket.entity;

import lombok.Data;

/**
 * @author JustEP
 * @version 1.0
 * @date 2021/7/17 22:06
 */
@Data
public class MessageBody {
    /**
     * 消息内容
     */
    private String content;
    /**
     * 广播转发的目标地址（告知 STOMP 代理转发到哪个地方）
     */
    private String destination;
}
