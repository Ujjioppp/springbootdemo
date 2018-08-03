package com.sb.sbdemo.config;

import com.sb.sbdemo.interceptor.AccessHandlerInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by ye on 1/8/18.
 */
@SpringBootConfiguration
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    AccessHandlerInterceptor accessHandlerInterceptor(){
        return new AccessHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessHandlerInterceptor()).addPathPatterns("/*");
    }
}
