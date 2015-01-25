package com.otis.marketing.security.authentication.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.otis.marketing.security.authentication.exception.UsernameOrPasswordIsNull;
import com.otis.marketing.security.authentication.token.OtisAuthenticationToken;

public class OtisAuthenticationProvider extends DaoAuthenticationProvider
		implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		OtisAuthenticationToken authenticationToken = (OtisAuthenticationToken) authentication;

		if (authenticationToken.getPrincipal() == null
				|| "".equals(authenticationToken.getPrincipal().toString())) {
			throw new UsernameOrPasswordIsNull("username is null");
		}
		String username = authenticationToken.getName();

		if (authentication.getCredentials() == null
				|| "".equals(authenticationToken.getCredentials().toString())) {
			throw new UsernameOrPasswordIsNull("password is null");
		}
		// String presentedPassword = authenticationToken.getCredentials()
		// .toString();

		UserDetails userDetails = getUserDetailsService().loadUserByUsername(
				username);

		if (!authentication.getCredentials().equals(userDetails.getPassword())) {
			throw new BadCredentialsException("password is error");
		}

		return new OtisAuthenticationToken(userDetails,
				authentication.getPrincipal(), userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return OtisAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
