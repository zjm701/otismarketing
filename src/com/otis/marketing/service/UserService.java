package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.web.dto.User;

public interface UserService {

	public void addUser(User userDto);

	public List<User> getAllUser();
}