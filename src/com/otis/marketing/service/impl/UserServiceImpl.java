package com.otis.marketing.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.UserDao;
import com.otis.marketing.entity.Role;
import com.otis.marketing.entity.Users;
import com.otis.marketing.security.crypto.PasswordManager;
import com.otis.marketing.service.UserService;
import com.otis.marketing.utils.CalendarUtils;
import com.otis.marketing.utils.Utils;
import com.otis.marketing.web.dto.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private UserDao userDao;
	
	public void addUser(User userDto) {
		
		Role role = userDao.findRoleByName("ROLE_USER");
		
		Users user = new Users();
		user.setEnabled(1);
		PasswordManager pm = PasswordManager.getInstance();
		try {
			user.setPassword(pm.encrypt(userDto.getPassword()));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			logger.error("Error! When encrypt the password during add new user.");
		}
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

	@Override
	public void updateUser(User user) {
		Users u =userDao.findById(user.getId());
		u.setUsername(user.getName());
		u.setUpdateDate(CalendarUtils.currentTime());
		
		PasswordManager pm = PasswordManager.getInstance();
		
		try {
			u.setPassword(pm.encrypt(user.getPassword()));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			logger.error("Error! When encrypt the password during update user.");
		}
		userDao.updateUser(u);
	}

	@Override
	public void deleteUser(Integer userId) {
		Users user =userDao.findById(userId);
		user.setEnabled(0);
		userDao.updateUser(user);
	}
	
	@Override
	public void updatePwd(Integer userId, String newPassWord) {
		PasswordManager pm = PasswordManager.getInstance();
		
		try {
			userDao.changePassWord(pm.encrypt(newPassWord), userId);
		} catch (DataAccessException | IllegalBlockSizeException
				| BadPaddingException e) {
			logger.error("Error! When encrypt the password during add new user.");
		}
	}

	@Override
	public Users getUserById(Integer userId) {
		return userDao.findById(userId);
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}