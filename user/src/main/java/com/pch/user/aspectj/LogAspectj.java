package com.pch.user.aspectj;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pch.user.model.dto.LogDTO;

import io.swagger.annotations.ApiOperation;

/**
 * 日志切面
 */
@Aspect
@Component
public class LogAspectj {

    @Pointcut("@annotation(com.pch.common.annotation.Log)")
    public void webLog() {
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        LogDTO logDTO = new LogDTO();
        HttpServletRequest request = requestAttributes.getRequest();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation annotation = method.getAnnotation(ApiOperation.class);
            String value = annotation.value();
            logDTO.setDescription(value);
        }
        return point.proceed();
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e         exception
     */
    @AfterThrowing(pointcut = "webLog()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("---");
    }

}
