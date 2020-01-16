package com.pch.user.aspectj;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p>使用aop记录controller日志</p>
 *
 * @author pch
 */
@Aspect
@Component
@Slf4j
public class AopLog {
    private static final String START_TIME = "request-start";

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.pch.user.controller.*Controller.*(..))")
    public void log() {

    }

    /**
     * 前置操作
     *
     * @param point 切入点
     */
    @Before("log()")
    public void beforeLog(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        log.error("【请求 URL】：{}", request.getRequestURL());
        log.error("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

//        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        log.error("【请求参数】：{}，", JSONUtil.toJsonStr(parameterMap));
//        log.error("【请求参数】：{}，", JSONUtil.toJsonStr(point.getArgs()));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        log.error("【返回值】：{}", result);
        return result;
    }

    /**
     * 后置操作
     */
    @AfterReturning("log()")
    public void afterReturning() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.error("【请求耗时】：{}毫秒", end - start);

        String header = request.getHeader("User-Agent");
//        UserAgent userAgent = UserAgent.parseUserAgentString(header);
//        log.error("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
    }
}
