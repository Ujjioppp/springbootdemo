package com.sb.sbdemo.websocket;

import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.util.WebSocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by ye on 25/9/18.
 */
@ServerEndpoint(value = "/wsServer/{param}")
@Component
@Slf4j
public class WebSocketServer {

    private Session session;


    @OnOpen
    public void onOpen(@PathParam("param") String param, Session session) {
        log.info("onOpen param:" + param);

        try {
            this.session = session;
            WebSocketUtil.set(param, this);
        } catch (BusiException e) {
            log.error(e.getMessage(), e);
        }
    }

    @OnClose
    public void onClose(@PathParam("param") String param, Session session) {
        log.info("onClose param:" + param);

        WebSocketUtil.remove(param);
    }

    @OnMessage
    public void onMessage(@PathParam("param") String param, String message, Session session) {
        log.info("onMessage param: [" + param + "] message : " + message);
        for (String key : WebSocketUtil.webSocketMap.keySet()) {
            if (StringUtils.equals(param, key)) {
                WebSocketUtil.get(param).send(message);
                break;
            }
        }
    }


    public void send(String msg) {
        this.session.getAsyncRemote().sendText(msg);
    }

}
