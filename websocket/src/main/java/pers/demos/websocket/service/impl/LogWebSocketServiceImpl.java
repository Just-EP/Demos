package pers.demos.websocket.service.impl;

import org.springframework.stereotype.Service;
import pers.demos.websocket.handler.LogWebSocketHandle;
import pers.demos.websocket.service.ILogWebSocketService;

/**
 * @author JustEP
 * @version 1.0
 * @date 2021/7/18 23:44
 */
@Service
public class LogWebSocketServiceImpl implements ILogWebSocketService {

    private final LogWebSocketHandle handle;

    public LogWebSocketServiceImpl(LogWebSocketHandle handle) {
        this.handle = handle;
    }

    @Override
    public void testLog() {
        handle.sendMessage("yes");
    }
}
