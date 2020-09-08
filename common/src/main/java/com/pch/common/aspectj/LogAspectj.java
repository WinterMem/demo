package com.pch.common.aspectj;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>使用aop记录controller日志</p>
 *
 * @author pch
 */
@Aspect
@Slf4j
@Configuration
public class LogAspectj {

    private static final String START_TIME = "request-start";

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.pch.*.controller.*Controller.*(..))")
    public void log() {

    }

    /**
     * 前置操作
     *
     * @param point 切入点
     */
    @Before("log()")
    public void beforeLog(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();

        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        LogAspectj.log.warn("【请求 URL】：{}", request.getRequestURL());
        LogAspectj.log.info("【请求 IP】：{}", request.getRemoteAddr());
        LogAspectj.log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(),
                point.getSignature().getName());

//        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        log.error("【请求参数】：{}，", JSONUtil.toJsonStr(parameterMap));
//        log.error("【请求参数】：{}，", JSONUtil.toJsonStr(point.getArgs()));
        Long start = System.currentTimeMillis();
        request.setAttribute(LogAspectj.START_TIME, start);
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
        // 获取参数名称
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        // 获取参数数值
        Object[] args = point.getArgs();
        for (int i = 0; i < args.length; i++) {
            LogAspectj.log.info("参数结果为{}：{}", parameterNames[i], args[i]);
        }
        LogAspectj.log.info("【返回值】：{}", result);
        return result;
    }

    /**
     * 后置操作
     */
    @AfterReturning("log()")
    public void afterReturning() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(LogAspectj.START_TIME);
        Long end = System.currentTimeMillis();
        LogAspectj.log.warn("【请求耗时】：{}毫秒", end - start);

        String header = request.getHeader("User-Agent");
//        UserAgent userAgent = UserAgent.parseUserAgentString(header);
//        log.error("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
    }
}
