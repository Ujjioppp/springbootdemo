package com.sb.sbdemo.util;

import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.websocket.WebSocketServer;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ye on 25/9/18.
 */
public class WebSocketUtil {

    public static ConcurrentMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<String, WebSocketServer>();

    public static WebSocketServer get(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }

        return webSocketMap.get(key);
    }

    public static void set(String key, WebSocketServer value) throws BusiException {
        if (StringUtils.isBlank(key)) {
            throw new BusiException("WebSocketMap set failed , KEY is null!");
        }
        webSocketMap.put(key, value);
    }

    public static WebSocketServer remove(String key) {
        return webSocketMap.remove(key);
    }

    public static boolean containsKey(String key) {
        return webSocketMap.containsKey(key);
    }


}
