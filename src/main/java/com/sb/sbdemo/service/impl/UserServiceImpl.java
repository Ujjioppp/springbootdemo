package com.sb.sbdemo.service.impl;

import com.sb.sbdemo.dao.UserMapper;
import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.model.User;
import com.sb.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ye on 3/8/18.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User loginUser) throws BusiException {
        if(Stringut)
        User user = this.userMapper.selectByUserName(loginUser.getUserName());
        return null;
    }
}
