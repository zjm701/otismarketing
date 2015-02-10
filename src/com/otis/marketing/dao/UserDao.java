package com.otis.marketing.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otis.marketing.entity.Role;
import com.otis.marketing.entity.Users;

public interface UserDao {

	public Users findByName(String userName) throws DataAccessException;
	
	public void saveUser(Users user) throws DataAccessException;
	
	public Role findRoleByName(String roleName) throws DataAccessException;

	public List<Users> findAllUser() throws DataAccessException;
	
	public void changePassWord(String newPassWord, Integer userId) throws DataAccessException;
	
	public void updateUser(Users user) throws DataAccessException;
	
	public Users findById(Integer userId) throws DataAccessException;
}
