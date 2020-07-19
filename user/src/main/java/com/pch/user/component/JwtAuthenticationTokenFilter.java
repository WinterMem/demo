package com.pch.user.component;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.StrUtil;
import com.pch.user.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Author: pch
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Value("${jwt.tokenHeader}")
	private String tokenHeader;

	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		String authHeader = request.getHeader(tokenHeader);
		if (StrUtil.isNotBlank(authHeader) && authHeader.startsWith(this.tokenHead)) {
			String authToken = authHeader.substring(this.tokenHead.length());
			String username = jwtUtil.getUserNameFromToken(authToken);
			JwtAuthenticationTokenFilter.log.info("checked username is :{}", username);
			if (StrUtil.isNotBlank(username)
					&& SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if (jwtUtil.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication =
							new UsernamePasswordAuthenticationToken(userDetails,
									null, userDetails.getAuthorities());
					authentication
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					JwtAuthenticationTokenFilter.log.info("authenticated user:{}", username);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		chain.doFilter(request, response);
	}
}
