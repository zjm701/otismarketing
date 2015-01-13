package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.entity.Users;

public interface UserService {

	public void saveUser(Users user);

	public void updateUser(Users user);

	public Users findUserById(int id);

	public void deleteUser(Users user);

	public List<Users> findAllList();

	public Users findUserByNameAndPassword(String username, String password);
}