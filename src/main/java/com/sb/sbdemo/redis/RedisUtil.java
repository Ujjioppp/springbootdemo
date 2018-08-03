package com.sb.sbdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by ye on 3/8/18.
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    public void setObj(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    public Object getObj(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }
}
