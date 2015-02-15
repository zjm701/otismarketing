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
	// 	判断用户所拥有的角色是否有访问当前请求资源的权限
	
	private static final Logger logger = Logger
			.getLogger(MultipleAccessDecisionManager.class);

	@Override
	public void decide(Authentication authentication, Object filter,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// 判断当前访问的资源
		if (logger.isDebugEnabled()) {
			logger.info("request user：" + authentication.getName());
		}

		// 遍历访问该资源的所需权限属性
		for (ConfigAttribute attribute : configAttributes) {
			// 遍历访问用户当前的权限属性
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
		// 不满足访问条件抛出异常
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
