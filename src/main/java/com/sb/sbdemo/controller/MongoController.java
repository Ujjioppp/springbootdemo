package com.sb.sbdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sb.sbdemo.model.MongoEntity;
import com.sb.sbdemo.service.MongoService;
import com.sb.sbdemo.util.IPUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ye on 30/8/18.
 */
@Controller
public class MongoController {
    @Autowired
    private MongoService mongoService;

    @ApiOperation(value = "mongo_set", notes = "验证mongo insert")
    @RequestMapping(value = "mongo_set", method = RequestMethod.GET)
    public String mongo_set(ModelMap modelMap, HttpServletRequest request) {
        String ip = IPUtil.getClientIp(request);
        MongoEntity mongoEntity = new MongoEntity(ip);
        this.mongoService.set(mongoEntity);
        modelMap.put("params", JSONObject.toJSONString(mongoEntity));
        return "mongo_set";
    }

    @ApiOperation(value = "mongo_get", notes = "查看mongo数据")
    @RequestMapping(value = "mongo_get", method = RequestMethod.GET)
    public String mongo_get(ModelMap modelMap) {
        modelMap.put("datas", this.mongoService.get());
        return "mongo_get";
    }
}
