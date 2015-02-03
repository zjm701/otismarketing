package com.otis.marketing.dao;

import java.util.List;

import com.otis.marketing.entity.Option;

public interface QuestionDao {

	public List<Option> getOptionsByQuestionId(Integer questionId);
}
