package com.otis.marketing.service;

import com.otis.marketing.entity.Users;

public interface UserService {

	public Users findUserByName(String userName);
}