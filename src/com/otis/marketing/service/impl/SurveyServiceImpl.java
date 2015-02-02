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
		Survey s = surveyDao.get(Survey.class, surveyId);
		s.setStatus(Survey.Status.Deleted.value());
		surveyDao.update(s);
	}

	@Override
	public void publish(int surveyId) {
		Survey s = surveyDao.get(Survey.class, surveyId);
		s.setStatus(Survey.Status.Published.value());
		surveyDao.update(s);
	}

	@Override
	public Survey getById(int surveyId) {
		return surveyDao.get(Survey.class, surveyId);
	}

	@Override
	public List<Survey> findAllSurvey() {
		return surveyDao.find(" from Survey s where status!=-1 order by s.createTime desc");
	}
}