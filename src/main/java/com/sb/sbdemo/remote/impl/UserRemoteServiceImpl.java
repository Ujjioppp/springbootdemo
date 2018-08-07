package com.sb.sbdemo.remote.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sb.sbdemo.remote.UserRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ye on 7/8/18.
 */
@Service
public class UserRemoteServiceImpl implements UserRemoteService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserRemoteServiceImpl.class);

    @Override
    public String remoteMethodOne() {
        LOGGER.info("DUBBO Service[UserRemoteServiceImpl] has been called");
        return "sbdubbo-provide method one return test";
    }
}
