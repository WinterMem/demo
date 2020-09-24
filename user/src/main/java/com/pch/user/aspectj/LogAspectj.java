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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pch.common.annotation.Logging;
import com.pch.common.config.IdSnowflake;
import com.pch.user.model.dto.LogDTO;
import com.pch.user.service.LogService;
import com.pch.user.util.SecurityUtils;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志切面
 */
@Aspect
@Order(100)
@Component
@Slf4j
public class LogAspectj {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.pch.common.annotation.Logging)")
    public void webLog() {
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        LogDTO logDTO = new LogDTO();
        String username = SecurityUtils.getAuthentication() != null ?
                SecurityUtils.getCurrentUsername() : "anonymousUser";
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 方法路径
        String methodName = point.getTarget().getClass().getName() + "." + signature.getName() + "()";
        // 获取注解信息
        Logging annotation = method.getAnnotation(Logging.class);
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        if (apiOperation != null) {
            logDTO.setDescription(apiOperation.value());
        }
        UserAgent parse = UserAgentUtil.parse(request.getHeader("User-Agent"));
        logDTO.setUsername(username)
                .setId(IdSnowflake.nextId())
                .setIp(ServletUtil.getClientIP(request))
                .setUserId(SecurityUtils.getCurrentUserId())
                .setMethod(methodName)
                .setBrowser(parse.getBrowser().getName() + " " + parse.getVersion())
                .setDescription(annotation.desc());
        logService.asyncSave(logDTO);
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
        log.error(e.toString());
    }

}
