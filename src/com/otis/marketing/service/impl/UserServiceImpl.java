package com.otis.marketing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.BaseDAO;
import com.otis.marketing.entity.Users;
import com.otis.marketing.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private BaseDAO<Users> baseDAO;

	public void saveUser(Users user) {
		baseDAO.save(user);
	}

	public void updateUser(Users user) {
		baseDAO.update(user);
	}

	public Users findUserById(int id) {
		return baseDAO.get(Users.class, id);
	}

	public void deleteUser(Users user) {
		baseDAO.delete(user);
	}

	public List<Users> findAllList() {
		return baseDAO.find(" from User u order by u.createTime");
	}

	public Users findUserByNameAndPassword(String username, String password) {
		return baseDAO.get(
				" from Users u where u.username = ? and u.password = ? ",
				new Object[] { username, password });
	}

}