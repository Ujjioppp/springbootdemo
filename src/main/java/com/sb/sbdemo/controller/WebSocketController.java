package com.sb.sbdemo.controller;

import com.sb.sbdemo.domain.WebSocketPushVO;
import com.sb.sbdemo.util.WebSocketUtil;
import com.sb.sbdemo.websocket.WebSocketServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ye on 25/9/18.
 */
@Controller
public class WebSocketController {

    @RequestMapping(value = "socket_index")
    public String socketIndex() {
        return "websocket";
    }

    @GetMapping(value = "websocket_push")
    public void websocketPush(WebSocketPushVO webSocketPushVO) {
        if (StringUtils.isNotBlank(webSocketPushVO.getReceiver())) {
            WebSocketServer webSocketServer = WebSocketUtil.get(webSocketPushVO.getReceiver());
            if (webSocketServer != null) {
                webSocketServer.send(webSocketPushVO.getMessage());
            }
        }
    }

    @GetMapping(value = "websocket_push_all")
    public void websocketPushAll(WebSocketPushVO webSocketPushVO) {
        for (String key : WebSocketUtil.webSocketMap.keySet()) {
            WebSocketUtil.get(key).send(webSocketPushVO.getMessage());
        }
    }
}
