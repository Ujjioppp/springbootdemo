package com.sb.sbdemo.sys;

import com.sb.sbdemo.model.User;
import com.sb.sbdemo.redis.RedisUtil;
import com.sb.sbdemo.redis.domain.CurrUserDomain;
import com.sb.sbdemo.redis.domain.manager.CurrUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by ye on 3/8/18.
 */
@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CurrUserManager userManager;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest request, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String sessionId = request.getSessionId();
        Object userObj = this.redisUtil.getObj(sessionId);
        if (userObj != null && userObj instanceof CurrUserDomain) {
            CurrUserDomain currUserDomain = (CurrUserDomain) userObj;
            return this.userManager.converToUser(currUserDomain);
        }
        return null;
    }
}
