package com.otis.marketing.security.manage.metadata;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MultipleFilterInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private OtisSecurityMetadataSource metadataSource;

	public OtisSecurityMetadataSource getMetadataSource() {
		return metadataSource;
	}

	public void setMetadataSource(OtisSecurityMetadataSource metadataSource) {
		this.metadataSource = metadataSource;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return metadataSource.getAllConfigAttributes();
	}

	public Collection<ConfigAttribute> getAttributes(Object filter)
			throws IllegalArgumentException {
		return metadataSource.getAttributes(filter);
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
