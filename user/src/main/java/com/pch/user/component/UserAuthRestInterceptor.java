package com.pch.user.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pch.common.annotation.Anonymous;

/**
 * @author: pch
 * @date: 2020/9/24
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Anonymous annotation = handlerMethod.getBeanType().getAnnotation(Anonymous.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(Anonymous.class);
        }
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
