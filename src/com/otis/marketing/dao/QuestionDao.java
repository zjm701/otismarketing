package com.otis.marketing.dao;

import java.util.List;

import com.otis.marketing.entity.Question;

public interface QuestionDao {
	
	public Question getQuestionById(Integer questionId);

//	public List<Option> getOptionsByQuestionId(Integer questionId);
}
