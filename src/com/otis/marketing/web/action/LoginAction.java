package com.otis.marketing.web.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.User;
import com.otis.marketing.service.UserService;

@SuppressWarnings("serial")
@Scope("request")
@Controller("loginAction")
public class LoginAction extends BaseAction {

	private static Logger logger = Logger.getLogger(LoginAction.class);

	@Autowired
	private UserService userService;

	private String password;

	private String userName;

	public String execute() throws Exception {
		User user = userService.findUserByNameAndPassword(userName, password);
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
