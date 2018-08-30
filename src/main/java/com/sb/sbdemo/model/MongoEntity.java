package com.sb.sbdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.thymeleaf.util.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by ye on 30/8/18.
 */
@Data
@AllArgsConstructor
public class MongoEntity implements Serializable {
    private String createTime = this.localDatetimeStr();

    private String uuid = UUID.randomUUID().toString();

    private String ip;

    private String localDatetimeStr() {
        Date now = new Date();
        String nowStr = DateUtils.format(now, "YYYY-MM-dd HH:mm:ss", Locale.CHINA);
        return nowStr;
    }

    public MongoEntity(String ip) {
        this.ip = ip;
    }
}
