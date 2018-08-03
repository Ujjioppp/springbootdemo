package com.sb.sbdemo.sys;

import com.sb.sbdemo.access.LoginAccess;
import com.sb.sbdemo.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ye on 1/8/18.
 */
@Component
@PropertySource(value = "classpath:config/const.properties", ignoreResourceNotFound = false)
public class AccessHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AccessHandlerInterceptor.class);

    @Value("${need.login}")
    private Boolean needLogin;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LoginAccess loginAccess = AnnotationUtils.getAnnotation(handlerMethod.getMethod(), LoginAccess.class);
            String sessionId = request.getRequestedSessionId();
            if (loginAccess != null && needLogin && redisUtil.getObj(sessionId) == null) {
                response.sendRedirect("/toLogin");
                return false;
            }
        }
        return true;
    }
}
