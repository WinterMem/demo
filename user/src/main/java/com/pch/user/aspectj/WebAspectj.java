package com.pch.user.aspectj;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.pch.common.annotation.Anonymous;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: pch
 * @date: 2020/9/16
 */
@Slf4j
@Aspect
@Component
public class WebAspectj {

    @Pointcut("execution(public * com.pch.user.controller.*.*(..))")
    public void webPoint() {
    }

    @Before("webPoint()")
    public void doBefore(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        Anonymous anonymous = method.getAnnotation(Anonymous.class);
    }

}
