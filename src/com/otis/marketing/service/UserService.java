package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.entity.Users;
import com.otis.marketing.web.dto.User;

public interface UserService {

	public void addUser(User userDto);

	public List<User> getAllUser();
	
	public void updatePwd(Integer userId, String newPassWord);
	
	public void updateUser(User user);
	
	public void deleteUser(Integer userId);
	
	public Users getUserById(Integer userId);
}