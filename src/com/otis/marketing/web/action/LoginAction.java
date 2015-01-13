package com.otis.marketing.web.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.Users;
import com.otis.marketing.service.UserService;

@SuppressWarnings("serial")
@Scope("request")
@Controller("loginAction")
public class LoginAction extends BaseAction {

	private static Logger logger = Logger.getLogger(LoginAction.class);

	@Autowired
	private UserService userService;

	private String password;

	private String username;

	public String execute() throws Exception {
		Users user = userService.findUserByNameAndPassword(username, password);
		if (user == null) {
			return ERROR;
		}
		
		getSession().put("user", user);
		return SUCCESS;
	}

	public String logout() throws Exception {
		return SUCCESS;
	}
	
	public String toWelcome() throws Exception {
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
