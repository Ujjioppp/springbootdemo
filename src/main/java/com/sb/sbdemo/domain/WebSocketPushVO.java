package com.sb.sbdemo.domain;

import lombok.Data;

/**
 * Created by ye on 25/9/18.
 */
@Data
public class WebSocketPushVO {

    private String receiver;

    private String message;
}
