package com.sb.sbdemo.service;

import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.model.User;

/**
 * Created by ye on 3/8/18.
 */
public interface UserService {

    User login(String key ,User user) throws BusiException;
}
