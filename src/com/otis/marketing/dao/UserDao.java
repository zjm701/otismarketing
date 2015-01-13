package com.otis.marketing.dao;

import org.springframework.dao.DataAccessException;

import com.otis.marketing.entity.Users;

public interface UserDao {

	public Users findByName(String userName) throws DataAccessException;
}
