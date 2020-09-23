package com.pch.user.service.impl;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pch.common.annotation.Log;
import com.pch.common.response.CommonResult;
import com.pch.user.model.domin.LogDO;
import com.pch.user.model.dto.LogDTO;
import com.pch.user.repository.LogRepository;
import com.pch.user.service.LogService;
import com.pch.user.service.mapper.LogMapper;
import com.pch.user.util.SecurityUtils;

/**
 * @author: pch
 * @date: 2020/9/10
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private LogMapper logMapper;

    @Override
    public void save(HttpServletRequest request, ProceedingJoinPoint point) throws Throwable {
        LogDTO logDTO = new LogDTO();
        String username = SecurityUtils.getAuthentication() != null ?
                SecurityUtils.getCurrentUsername() : "AnonymousUser";
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Object proceed = point.proceed();
        if (proceed instanceof CommonResult) {
            Object data = ((CommonResult<?>) proceed).getData();
        }
        // 方法路径
        String methodName = point.getTarget().getClass().getName() + "." + signature.getName() + "()";
        // 获取注解信息
        Log annotation = method.getAnnotation(Log.class);
        logDTO.setUsername(username)
//                .setRequestIp()
                .setId(SecurityUtils.getCurrentUserId())
                .setMethod(methodName)
                .setDescription(annotation.desc());
    }

    @Override
    public List<LogDTO> findAll() {
        List<LogDO> all = logRepository.findAll();
        return all.stream().map(logDO -> logMapper.toEntity(logDO)).collect(Collectors.toList());
    }

    @Override
    public Long save(LogDTO logDTO) {
        LogDO logDO = logMapper.toDto(logDTO);
        LogDO save = logRepository.save(logDO);
        return save.getId();
    }

}
