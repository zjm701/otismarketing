package com.otis.marketing.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.entity.Users;
import com.otis.marketing.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Override
	public Users findUserByName(String userName) {
		return null;
	}

}