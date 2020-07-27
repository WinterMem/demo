package com.pch.user.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class InterceptAop {

	@Pointcut("@annotation(com.pch.user.annotation.AnnotationAop)")
	public void annotationAop() {
	}

	@Before("annotationAop()")
	public void beforeAnnotation(JoinPoint joinpoint) {

		InterceptAop.log.info("annotation before : {}", "aop intercept ");
	}

	@After("annotationAop()")
	public void afterAnnotation(JoinPoint joinPoint) {
		InterceptAop.log.info("annotation after : {}", "aop intercept ");
	}

}
