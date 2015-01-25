package com.otis.marketing.security.manage.metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;

import com.otis.marketing.dao.ResourceDao;
import com.otis.marketing.entity.Resources;

public class OtisSecurityMetadataSource implements SecurityMetadataSource {

	private static final Logger logger = Logger
			.getLogger(OtisSecurityMetadataSource.class);

	private ResourceDao resourceDao;

	private List<Resources> resources;

	@PostConstruct
	public void init() {
		resources = this.resourceDao.findAll();
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Collection<ConfigAttribute> collection = new ArrayList<ConfigAttribute>();
		for (Resources res : resources) {
			if (res.getConfigAttributes() != null) {
				collection.addAll(res.getConfigAttributes());
			}
		}
		return collection;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object filter)
			throws IllegalArgumentException {

		Collection<ConfigAttribute> collection = new ArrayList<ConfigAttribute>();
		HttpServletRequest request = ((FilterInvocation) filter).getRequest();
		for (Resources res : resources) {
			if (res.matches(request)) {
				collection = res.getConfigAttributes();
				break;
			}
		}
		if (logger.isDebugEnabled()) {
			logger.info("request URL："
					+ ((FilterInvocation) filter).getRequestUrl());
		}
		return collection;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

}
