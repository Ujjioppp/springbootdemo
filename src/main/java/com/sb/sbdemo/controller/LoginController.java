package com.sb.sbdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ye on 1/8/18.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }
}
