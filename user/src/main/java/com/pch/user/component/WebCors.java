package com.pch.user.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pch.user.config.AsyncPorpoise;

/**
 * @author: pch
 * @date: 2020/9/9
 */
@Configuration
public class WebCors implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);
    }
    
    @Bean
    public AsyncPorpoise getAsyncPorpoise() {
        return new AsyncPorpoise();
    }
}
