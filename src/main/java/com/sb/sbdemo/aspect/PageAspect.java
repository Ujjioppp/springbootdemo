package com.sb.sbdemo.aspect;

import com.github.pagehelper.PageHelper;
import com.sb.sbdemo.access.PageAccess;
import com.sb.sbdemo.page.PageInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by ye on 1/8/18.
 */
@Component
@Aspect
public class PageAspect {
    @Pointcut("execution(public * com.sb.sbdemo.service.impl.*.*(..))")
    public void page() {
    }


    @Before("page()")
    public void beforeSelect(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        PageAccess pageAccess = AnnotationUtils.getAnnotation(method, PageAccess.class);
        PageInfo pageInfo = null;
        for (Object obj : joinPoint.getArgs()) {
            if (obj instanceof PageInfo) {
                pageInfo = (PageInfo) obj;
                break;
            }
        }
        if (pageAccess != null) {
            PageHelper.startPage(pageInfo);
        }
    }

}
