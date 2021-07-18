package pers.demos.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.demos.websocket.service.ILogWebSocketService;

/**
 * @author JustEP
 * @version 1.0
 * @date 2021/7/18 23:45
 */
@Controller
public class LogWebSocketController {

    private final ILogWebSocketService iLogWebSocketService;

    public LogWebSocketController(ILogWebSocketService iLogWebSocketService) {
        this.iLogWebSocketService = iLogWebSocketService;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String testLog(){
        iLogWebSocketService.testLog();
        return "success";
    }
}
