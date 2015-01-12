package com.otis.marketing.web.action;

import java.util.Map;

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
	
	protected Map<String, Object> getSession(){
		return getContext().getSession();
	}
}
