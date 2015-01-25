package com.otis.marketing.security.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class MultipleAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	private String directUrl;

	public void setDirectUrl(String directUrl) {
		this.directUrl = directUrl;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		setDefaultTargetUrl(directUrl);
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
