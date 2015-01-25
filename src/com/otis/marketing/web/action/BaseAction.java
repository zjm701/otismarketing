package com.otis.marketing.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class BaseAction extends ActionSupport {

	private ActionContext ctx;

	protected ActionContext getContext() {
		if (ctx == null) {
			ctx = ActionContext.getContext();
		}
		return ctx;
	}

	public ServletContext getApplication() {
		return ServletActionContext.getServletContext();
	}

	protected Map<String, Object> getSession(){
		return getContext().getSession();
	}
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public Object getAttribute(String name) {
		return ServletActionContext.getRequest().getAttribute(name);
	}

	public void setAttribute(String name, Object value) {
		ServletActionContext.getRequest().setAttribute(name, value);
	}

	public String getParameter(String name) {
		return getRequest().getParameter(name);
	}
	
	public String[] getParameterValues(String name) {
		return getRequest().getParameterValues(name);
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

}
