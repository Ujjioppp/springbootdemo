package com.sb.sbdemo.decorator;

import com.sb.sbdemo.constant.KeyConst;
import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.model.User;
import com.sb.sbdemo.redis.RedisUtil;
import com.sb.sbdemo.redis.domain.manager.UserManager;
import com.sb.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by ye on 3/8/18.
 */
@Service
@Primary
public class UserDecorator implements UserService {

    @Autowired
    @Qualifier(KeyConst.BeanName.USER_SERVICE)
    private UserService userService;

    @Autowired
    private UserManager userManager;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User login(String key, User user) throws BusiException {
        User currUser = this.userService.login(key, user);
        redisUtil.setObj(key, this.userManager.convertToUserDomain(currUser));
        return currUser;
    }
}
