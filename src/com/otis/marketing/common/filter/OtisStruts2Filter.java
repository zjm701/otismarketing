package com.otis.marketing.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.StrutsRequestWrapper;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtisStruts2Filter extends StrutsPrepareAndExecuteFilter {

	private static Logger log = LoggerFactory
			.getLogger(OtisStruts2Filter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		try {
			HttpServletRequest request = (HttpServletRequest) req;
			if (request.getRequestURI().contains("/webservice")) {
				chain.doFilter(req, res);
			} else if (request.getRequestURI().contains("/ueditor1_4_3/jsp/")) {
				chain.doFilter(new StrutsRequestWrapper((HttpServletRequest) req), res);
			} else {
				super.doFilter(req, res, chain);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
