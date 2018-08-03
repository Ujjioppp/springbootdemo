package com.sb.sbdemo.controller;

import com.sb.sbdemo.controller.form.UserForm;
import com.sb.sbdemo.controller.form.manager.UserFormManager;
import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.model.User;
import com.sb.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by ye on 1/8/18.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFormManager userFormManager;

    @RequestMapping(value = "toLogin")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "/login")
    public String login(UserForm user, ModelMap modelMap, HttpSession session) throws BusiException {
        User currUser = this.userService.login(session.getId(), this.userFormManager.convertToUser(user));
        modelMap.put("user", currUser);
        return "login_success";
    }
}
