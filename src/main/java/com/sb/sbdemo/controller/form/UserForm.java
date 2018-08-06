package com.sb.sbdemo.controller.form;

import javax.validation.constraints.NotBlank;

/**
 * Created by ye on 3/8/18.
 */
public class UserForm {

    @NotBlank(message = "can not be null or empty")
    private String userName;

    @NotBlank(message = "can not be null or empty")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

