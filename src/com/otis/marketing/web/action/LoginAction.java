package com.otis.marketing.web.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.Users;
import com.otis.marketing.security.OtisContext;

@SuppressWarnings("serial")
@Scope("request")
@Controller("loginAction")
public class LoginAction extends BaseAction {

	private static Logger logger = Logger.getLogger(LoginAction.class);

	public String toMain() {
		Users user = OtisContext.getContextUser();
		getSession().put("user", user);

		Collection<GrantedAuthority> permissions = (Collection<GrantedAuthority>) OtisContext
				.getContextAuthorities();

		if (permissions.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			return "adminMain";
		}
		if (permissions.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
			return "userMain";
		}
		return ERROR;
	}

	public String goLogin() {
		return "goLogin";
	}
	
	public String loginFailure() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("loginFailureMsg", "用户名或密码错误，请重新登录！");
		return "goLogin";
	}
}
