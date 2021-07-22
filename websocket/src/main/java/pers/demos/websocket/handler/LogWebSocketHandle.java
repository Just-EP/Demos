package pers.demos.websocket.handler;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author JustEP
 * @version 1.0
 * @date 2021/7/18 23:32
 */
@ServerEndpoint("/logs")
@Component
public class LogWebSocketHandle {

    @OnOpen
    public void onOpen(Session session) {
        // 建议开启线程处理，避免 open 阻塞
        try {
            if (session.isOpen()) {
                SessionSaver instance = SessionSaver.getInstance(session);
                instance.getSession().getBasicRemote().sendText("Hello" + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("message is arrived: " + message);
    }

    public void sendMessage(String message) {
        try {
            SessionSaver sessionSaver = SessionSaver.getInstance();
            sessionSaver.getSession().getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
