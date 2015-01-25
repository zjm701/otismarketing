package com.otis.marketing.security.authentication.token;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;


public class OtisAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -1080396871514171817L;
	
	public OtisAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}
	
	public OtisAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
    }
}
