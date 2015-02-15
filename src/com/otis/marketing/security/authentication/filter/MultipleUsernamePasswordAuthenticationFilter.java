package com.otis.marketing.security.authentication.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MultipleUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {

	private OtisAuthenticationTokenResolver tokenResolver;

	//重写身份验证方法
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) {
		// 获得用户凭证
		Authentication authentication = tokenResolver.resolve(request);
		// 验证用户凭证
		return this.getAuthenticationManager().authenticate(authentication);
	}

	public OtisAuthenticationTokenResolver getTokenResolver() {
		return tokenResolver;
	}

	public void setTokenResolver(OtisAuthenticationTokenResolver tokenResolver) {
		this.tokenResolver = tokenResolver;
	}

}
