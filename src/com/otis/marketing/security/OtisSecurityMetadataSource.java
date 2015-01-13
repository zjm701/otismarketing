package com.otis.marketing.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.otis.marketing.dao.ResourceDao;
import com.otis.marketing.entity.Resources;

public class OtisSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private ResourceDao resourceDao;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public OtisSecurityMetadataSource(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
		loadResourceDefine();
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Resources> resources = this.resourceDao.findAll();
			for (Resources resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				ConfigAttribute configAttribute = new SecurityConfig(
						resource.getName());
				configAttributes.add(configAttribute);
				resourceMap.put(resource.getUrl(), configAttributes);
			}
		}

		// Set<Entry<String, Collection<ConfigAttribute>>> resourceSet =
		// resourceMap
		// .entrySet();
		// Iterator<Entry<String, Collection<ConfigAttribute>>> iterator =
		// resourceSet
		// .iterator();

	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		if (resourceMap == null) {
			loadResourceDefine();
		}

		return resourceMap.get(requestUrl);
	}
}
