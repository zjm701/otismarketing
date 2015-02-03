package com.otis.marketing.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.web.dto.User;

@Scope("request")
@Controller("userAction")
public class UserAction extends BaseAction{

	private static final long serialVersionUID = -5669378851021056095L;

	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private List<User> data = new ArrayList<User>();
	
	public String goUserInfoMain() {
		return SUCCESS;
	}
	
	public String getUserInfoList () {
		User user1 = new User();
		user1.setId(1);
		user1.setName("user1");
		user1.setPassword("123");
		user1.setCreateDate("2010-1-1");
		user1.setUpdateDate("2010-1-1");
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("user2");
		user2.setPassword("123");
		user2.setCreateDate("2010-1-2");
		user2.setUpdateDate("2010-1-2");
		
		User user3 = new User();
		user3.setId(3);
		user3.setName("user3");
		user3.setPassword("123");
		user3.setCreateDate("2010-1-3");
		user3.setUpdateDate("2010-1-3");
		data.add(user1);
		data.add(user2);
		data.add(user3);
		
		return "userInfos";
	}

	public List<User> getData() {
		return data;
	}

}
