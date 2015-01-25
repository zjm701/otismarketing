package com.otis.marketing.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.otis.marketing.entity.Users;

public class OtisContext {

	public static Users getContextUser() {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null || !au.isAuthenticated())
			return null;
		else
			return (Users)au.getPrincipal();
	}
	
	public static Collection<? extends GrantedAuthority> getContextAuthorities() {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null || !au.isAuthenticated())
			return null;
		else
			return au.getAuthorities();
	}
}
