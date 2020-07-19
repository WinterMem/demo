package com.pch.user.config;

import com.pch.user.component.DynamicAccessDecisionManager;
import com.pch.user.component.DynamicSecurityFilter;
import com.pch.user.component.DynamicSecurityMetadataSource;
import com.pch.user.component.DynamicSecurityService;
import com.pch.user.component.JwtAuthenticationTokenFilter;
import com.pch.user.component.RestAuthenticationEntryPoint;
import com.pch.user.component.RestfulAccessDeniedHandler;
import com.pch.user.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: pch
 * @Description:
 * @Date: Created in 11:50 2020/6/4
 * @Modified By:
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired(required = false)
	private DynamicSecurityService dynamicSecurityService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
				httpSecurity.authorizeRequests();
		for (String url : ignoreUrlsConfig().getUrls()) {
			registry.antMatchers(url).permitAll();
		}
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
				.authenticationEntryPoint(restAuthenticationEntryPoint())
				// 自定义权限拦截器JWT过滤器
				.and()
				.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		if (dynamicSecurityService != null) {
			registry.and().addFilterBefore(dynamicSecurityFilter(), FilterSecurityInterceptor.class);
		}
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Bean
	public IgnoreUrlsConfig ignoreUrlsConfig() {
		return new IgnoreUrlsConfig();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
		return new JwtAuthenticationTokenFilter();
	}

	@Bean
	public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
		return new RestfulAccessDeniedHandler();
	}

	@Bean
	public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
		return new RestAuthenticationEntryPoint();
	}

	@ConditionalOnBean(name = "dynamicSecurityService")
	@Bean
	public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
		return new DynamicAccessDecisionManager();
	}

	@ConditionalOnBean(name = "dynamicSecurityService")
	@Bean
	public DynamicSecurityFilter dynamicSecurityFilter() {
		return new DynamicSecurityFilter();
	}

	@ConditionalOnBean(name = "dynamicSecurityService")
	@Bean
	public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
		return new DynamicSecurityMetadataSource();
	}

	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil();
	}
}
