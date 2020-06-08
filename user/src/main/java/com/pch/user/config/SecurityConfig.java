package com.pch.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.pch.user.component.RestAuthenticationEntryPoint;
import com.pch.user.component.RestfulAccessDeniedHandler;

/**
 * @Author: pch
 * @Description:
 * @Date: Created in 11:50 2020/6/4
 * @Modified By:
 */
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
            .authorizeRequests();
        registry.antMatchers(HttpMethod.OPTIONS)
            .permitAll();
        // 任何请求需要身份认证
        registry.and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            // 关闭跨站请求防护及不使用session
            .and()
            .csrf()
            .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            // 自定义权限拒绝处理类
            .and()
            .exceptionHandling()
            .accessDeniedHandler(restfulAccessDeniedHandler())
            .authenticationEntryPoint(restAuthenticationEntryPoint());
//            // 自定义权限拦截器JWT过滤器
//            .and()
//            .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
        return new RestfulAccessDeniedHandler();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }
}
