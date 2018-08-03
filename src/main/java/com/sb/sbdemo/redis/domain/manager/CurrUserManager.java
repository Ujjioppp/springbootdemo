package com.sb.sbdemo.redis.domain.manager;

import com.sb.sbdemo.model.User;
import com.sb.sbdemo.redis.domain.CurrUserDomain;
import org.springframework.stereotype.Service;

/**
 * Created by ye on 3/8/18.
 */
@Service
public class CurrUserManager {
    public CurrUserDomain convertToUserDomain(User user) {
        CurrUserDomain currUserDomain = null;
        if (user != null) {
            currUserDomain = new CurrUserDomain();
            currUserDomain.setUserName(user.getUserName());
        }
        return currUserDomain;
    }

    public User converToUser(CurrUserDomain currUserDomain) {
        User user = null;
        if (currUserDomain != null) {
            user = new User();
            user.setUserName(currUserDomain.getUserName());
        }
        return user;
    }
}
