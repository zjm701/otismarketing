package com.otis.marketing.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otis.marketing.dao.SurveyDao;
import com.otis.marketing.entity.Survey;

public class SurveyDaoImpl extends BaseDao<Survey> implements SurveyDao {

	public Survey get(int id) throws DataAccessException {
		return super.get(Survey.class, id);
	}

	public List<Survey> findAllSurvey() throws DataAccessException {
		return super.find(" from Survey s where s.status!=-1 order by s.createTime desc");
	}
}