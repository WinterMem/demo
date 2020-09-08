package com.pch.common.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class InterceptAop {

	@Pointcut("@annotation(com.pch.common.annotation.Log)")
	public void annotationAop() {
	}

	@Around("annotationAop()")
	public void around(JoinPoint joinPoint) {

	}

}
