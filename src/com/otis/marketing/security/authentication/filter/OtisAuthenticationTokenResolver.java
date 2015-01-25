package com.otis.marketing.security.authentication.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;

import com.otis.marketing.security.authentication.token.OtisAuthenticationToken;

public class OtisAuthenticationTokenResolver {

	private static final Logger logger = Logger
			.getLogger(OtisAuthenticationTokenResolver.class);
	
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	public Authentication resolve(HttpServletRequest request) {
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		if (logger.isDebugEnabled()) {
			logger.info("login user：" + username);
		}
		return new OtisAuthenticationToken(username, password);
	}
}
