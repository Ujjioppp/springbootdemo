package com.sb.sbdemo.controller;

import com.sb.sbdemo.access.LoginAccess;
import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.model.FfaDemand;
import com.sb.sbdemo.model.User;
import com.sb.sbdemo.page.PageInfo;
import com.sb.sbdemo.service.FfaDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

/**
 * Created by ye on 1/8/18.
 */
@Controller
public class IndexController {
    @Value("${exception.probability.radix}")
    private Integer radix;

    @Autowired
    private FfaDemandService ffaDemandService;

    @RequestMapping(value = "/")
    public String index(ModelMap modelMap, PageInfo pageInfo) {
        List<FfaDemand> ffaDemandList = this.ffaDemandService.queryList(pageInfo);
        modelMap.put("demandList", ffaDemandList);
        modelMap.put("page", pageInfo);
        return "index";
    }

    @RequestMapping(value = "/login_access")
    @LoginAccess
    public String loginAccess() {
        return "login_access";
    }


    @RequestMapping(value = "/busi_excep")
    public String busiExcep() throws BusiException {
        int probability = new Random().nextInt(radix);
        if (probability > radix / 2)
            throw new BusiException("on purpose");
        return "200";
    }

    @RequestMapping(value = "inject_user")
    @LoginAccess
    public String injectUser(User user, ModelMap modelMap) {
        modelMap.put("user", user);
        return "inject_user";
    }
}
