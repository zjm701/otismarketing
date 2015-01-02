package com.otis.marketing.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.otis.marketing.entity.User;
import com.otis.marketing.service.UserService;

@Scope("request")
@Controller("loginAction")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	private String password;

	private String userName;

	public String execute() throws Exception {
		User user = userService.findUserByNameAndPassword(userName, password);
		if(user == null) {
			return ERROR;
		}
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
