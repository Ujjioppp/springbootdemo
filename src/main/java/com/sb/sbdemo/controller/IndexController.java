package com.sb.sbdemo.controller;

import com.sb.sbdemo.access.LoginAccess;
import com.sb.sbdemo.exception.BusiException;
import com.sb.sbdemo.model.FfaDemand;
import com.sb.sbdemo.model.User;
import com.sb.sbdemo.page.PageInfo;
import com.sb.sbdemo.service.FfaDemandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @ApiOperation(value = "首页", notes = "首页")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap, PageInfo pageInfo) {
        List<FfaDemand> ffaDemandList = this.ffaDemandService.queryList(pageInfo);
        modelMap.put("demandList", ffaDemandList);
        modelMap.put("page", pageInfo);
        return "index";
    }

    @ApiOperation(value = "验证是否需要登录", notes = "验证是否需要登录")
    @RequestMapping(value = "/login_access", method = RequestMethod.GET)
    @LoginAccess
    public String loginAccess() {
        return "login_access";
    }


    @ApiOperation(value = "有一定几率抛出BusiException", notes = "有一定几率抛出BusiException")
    @RequestMapping(value = "/busi_excep", method = RequestMethod.GET)
    public String busiExcep() throws BusiException {
        int probability = new Random().nextInt(radix);
        if (probability > radix / 2)
            throw new BusiException("on purpose");
        return "200";
    }

    @ApiOperation(value = "验证是否能自动注入User", notes = "验证是否能自动注入User")
    @RequestMapping(value = "inject_user", method = RequestMethod.GET)
    @LoginAccess
    public String injectUser(User user, ModelMap modelMap) {
        modelMap.put("user", user);
        return "inject_user";
    }

}
