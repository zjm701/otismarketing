package com.otis.marketing.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.entity.Question;

public interface QuestionDao{
	
	public Question get(int id) throws DataAccessException;

//	public List<Option> getOptionsByQuestionId(Integer questionId);
}
