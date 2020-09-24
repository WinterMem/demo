package com.pch.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pch.user.component.UserAuthRestInterceptor;

/**
 * @author: pch
 * @date: 2020/9/9
 */
@Primary
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHandlerInterceptorAdapter()).excludePathPatterns(ignoreUrlsConfig.getUrls());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);
    }

    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    @Bean
    public HandlerInterceptorAdapter getHandlerInterceptorAdapter() {
        return new UserAuthRestInterceptor();
    }

    @Bean
    public AsyncPorpoise getAsyncPorpoise() {
        return new AsyncPorpoise();
    }
}
