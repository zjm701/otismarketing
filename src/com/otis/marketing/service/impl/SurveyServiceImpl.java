package com.otis.marketing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.entity.Survey;
import com.otis.marketing.service.SurveyService;

@Service("surveyService")
@Transactional
public class SurveyServiceImpl implements SurveyService {

	@Override
	public void create(Survey survey) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Survey survey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int surveyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Survey> findAllSurvey() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Resource
//	private BaseDAO<Survey> baseDAO;
//
//	public void saveUser(User user) {
//		baseDAO.save(user);
//	}

//	public void updateUser(User user) {
//		baseDAO.update(user);
//	}
//
//	public User findUserById(int id) {
//		return baseDAO.get(User.class, id);
//	}
//
//	public void deleteUser(User user) {
//		baseDAO.delete(user);
//	}
//
//	public List<User> findAllList() {
//		return baseDAO.find(" from User u order by u.createTime");
//	}
//
//	public User findUserByNameAndPassword(String username, String password) {
//		return baseDAO.get(
//				" from User u where u.userName = ? and u.password = ? ",
//				new Object[] { username, password });
//	}

}