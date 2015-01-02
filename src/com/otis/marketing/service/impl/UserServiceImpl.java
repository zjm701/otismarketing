package com.otis.marketing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.BaseDAO;
import com.otis.marketing.entity.User;
import com.otis.marketing.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private BaseDAO<User> baseDAO;

	public void saveUser(User user) {
		baseDAO.save(user);
	}

	public void updateUser(User user) {
		baseDAO.update(user);
	}

	public User findUserById(int id) {
		return baseDAO.get(User.class, id);
	}

	public void deleteUser(User user) {
		baseDAO.delete(user);
	}

	public List<User> findAllList() {
		return baseDAO.find(" from User u order by u.createTime");
	}

	public User findUserByNameAndPassword(String username, String password) {
		return baseDAO.get(
				" from User u where u.userName = ? and u.password = ? ",
				new Object[] { username, password });
	}

}