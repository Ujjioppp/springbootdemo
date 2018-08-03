package com.sb.sbdemo.redis.domain;

import java.io.Serializable;

/**
 * Created by ye on 3/8/18.
 */
public class CurrUserDomain implements Serializable {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
