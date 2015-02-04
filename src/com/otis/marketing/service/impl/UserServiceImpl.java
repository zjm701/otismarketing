package com.otis.marketing.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.UserDao;
import com.otis.marketing.entity.Role;
import com.otis.marketing.entity.Users;
import com.otis.marketing.service.UserService;
import com.otis.marketing.utils.CalendarUtils;
import com.otis.marketing.utils.Utils;
import com.otis.marketing.web.dto.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void addUser(User userDto) {
		
		Role role = userDao.findRoleByName("ROLE_USER");
		
		Users user = new Users();
		user.setEnabled(1);
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getName());
		user.setCreateDate(CalendarUtils.currentTime());
		user.setUpdateDate(CalendarUtils.currentTime());
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		userDao.saveUser(user);
	}
	
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		
		List<Users> allUser = userDao.findAllUser();
		
		for(Users user : allUser) {
			User dto = new User();
			dto.setId(user.getId());
			dto.setName(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setUpdateDate(Utils.formateDate(user.getUpdateDate()));
			dto.setCreateDate(Utils.formateDate(user.getCreateDate()));
			
			users.add(dto);
		}
		
		return users;
	}

	

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}