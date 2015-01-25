package com.otis.marketing.security.manage.decide;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MultipleAccessDecisionManager implements AccessDecisionManager {

	private static final Logger logger = Logger
			.getLogger(MultipleAccessDecisionManager.class);

	@Override
	public void decide(Authentication authentication, Object filter,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (logger.isDebugEnabled()) {
			logger.info("request user：" + authentication.getName());
		}

		for (ConfigAttribute attribute : configAttributes) {
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if (attribute.getAttribute().equals(authority.getAuthority())) {
					if (logger.isDebugEnabled()) {
						logger.info("current user:" + authority.getAuthority()
								+ "can access it");
					}
					return;
				}
			}
		}
		throw new AccessDeniedException("no access auth!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
