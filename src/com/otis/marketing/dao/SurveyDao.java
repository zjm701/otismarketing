package com.otis.marketing.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otis.marketing.entity.Survey;

public interface SurveyDao {

	public void save(Survey s) throws DataAccessException;

	public void update(Survey s) throws DataAccessException;

	public Survey get(int id) throws DataAccessException;

	public List<Survey> findAllSurvey() throws DataAccessException;

	public int updateSurveysToEnd(Date endDate) throws DataAccessException;
}
