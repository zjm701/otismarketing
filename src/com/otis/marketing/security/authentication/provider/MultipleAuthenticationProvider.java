package com.otis.marketing.security.authentication.provider;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MultipleAuthenticationProvider implements AuthenticationProvider {

	private List<AuthenticationProvider> authenticationProviders;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		Authentication authenticationToken = null;
		for (AuthenticationProvider authenticationProvider : authenticationProviders) {
			if (authenticationProvider.supports(authentication.getClass())) {
				authenticationToken = authenticationProvider
						.authenticate(authentication);
			}
		}
		return authenticationToken;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return true;
	}

	public List<AuthenticationProvider> getAuthenticationProviders() {
		return authenticationProviders;
	}

	public void setAuthenticationProviders(
			List<AuthenticationProvider> authenticationProviders) {
		this.authenticationProviders = authenticationProviders;
	}
}
