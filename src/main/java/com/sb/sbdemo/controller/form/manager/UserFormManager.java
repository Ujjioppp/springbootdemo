package com.sb.sbdemo.controller.form.manager;

import com.sb.sbdemo.controller.form.UserForm;
import com.sb.sbdemo.model.User;
import com.sb.sbdemo.redis.domain.CurrUserDomain;
import org.springframework.stereotype.Service;

/**
 * Created by ye on 3/8/18.
 */
@Service
public class UserFormManager {
    public User convertToUser(UserForm userForm){
        User user = null;
            if (userForm != null) {
                user = new User();
                user.setUserName(userForm.getUserName());
                user.setPassword(userForm.getPassword());
            }
            return user;
    }
}
