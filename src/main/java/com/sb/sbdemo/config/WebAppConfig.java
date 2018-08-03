package com.sb.sbdemo.config;

import com.sb.sbdemo.sys.AccessHandlerInterceptor;
import com.sb.sbdemo.sys.CurrentUserArgumentResolver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by ye on 1/8/18.
 */
@SpringBootConfiguration
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    AccessHandlerInterceptor accessHandlerInterceptor() {
        return new AccessHandlerInterceptor();
    }

    @Bean
    CurrentUserArgumentResolver currentUserArgumentResolver() {
        return new CurrentUserArgumentResolver();
    }

    /**
     * 拦截器-管理@LoginAccess
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessHandlerInterceptor()).addPathPatterns("/*");
    }

    /**
     * 注入Controller User参数
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserArgumentResolver());
    }
}
