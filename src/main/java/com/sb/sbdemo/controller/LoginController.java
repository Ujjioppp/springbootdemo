package com.sb.sbdemo.controller;

import com.sb.sbdemo.controller.form.UserForm;
import com.sb.sbdemo.controller.form.manager.UserFormManager;
import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.model.User;
import com.sb.sbdemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by ye on 1/8/18.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFormManager userFormManager;

    @ApiIgnore
    @RequestMapping(value = "toLogin", method = RequestMethod.GET)
    public String login(@ModelAttribute("userForm") UserForm userForm) {
        return "login";
    }


    @ApiOperation(value = "登录接口", notes = "登录接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult bindingResult, ModelMap modelMap, HttpSession session) throws BusiException {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        User currUser = this.userService.login(session.getId(), this.userFormManager.convertToUser(userForm));
        modelMap.put("user", currUser);
        return "login_success";
    }
}
