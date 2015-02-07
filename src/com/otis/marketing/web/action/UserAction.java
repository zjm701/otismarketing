package com.otis.marketing.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.Users;
import com.otis.marketing.security.OtisContext;
import com.otis.marketing.service.UserService;
import com.otis.marketing.web.dto.User;

@Scope("request")
@Controller("userAction")
public class UserAction extends BaseAction{

	private static final long serialVersionUID = -5669378851021056095L;

	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private List<User> data = new ArrayList<User>();
	
	private String userName;
	
	private String password;
	
	@Autowired
	private UserService userService;
	
	public String goUserInfoMain() {
		return SUCCESS;
	}
	
	public String getUserInfoList () {
		
		List<User> users = userService.getAllUser();
		data.addAll(users);
		return "userInfos";
	}

	public String addUser() {
		User user = new User();
		user.setName(userName);
		user.setPassword(password);
		
		userService.addUser(user);
		
		return SUCCESS;
	}
	
	public String goUpdatePwd() {
		return SUCCESS;
	}
	
	public String changePassword() {
		Users user = OtisContext.getContextUser();
		userService.updatePwd(user.getId(), password);
		return SUCCESS;
	}
	
	public List<User> getData() {
		return data;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
