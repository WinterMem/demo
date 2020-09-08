package com.pch.user.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class InterceptAop {

	@Pointcut("@annotation(com.pch.user.annotation.Log)")
	public void annotationAop() {
	}

	@Around("annotationAop()")
	public void around(JoinPoint joinPoint) {

	}

}
