package com.otis.marketing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.BaseDAO;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.service.SurveyService;

@Service("surveyService")
@Transactional
public class SurveyServiceImpl implements SurveyService {
	@Resource
	private BaseDAO<Survey> surveyDao;

	@Override
	public void create(Survey survey) {
		surveyDao.save(survey);
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
	public Survey getById(int id) {
		return surveyDao.get(Survey.class,id);
	}

	@Override
	public List<Survey> findAllSurvey() {
		return surveyDao.find(" from Survey s order by s.createTime desc");
	}
}