package com.otis.marketing.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.SurveyDao;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.service.SurveyService;
import com.otis.marketing.utils.CalendarUtils;

@Service("surveyService")
@Transactional
public class SurveyServiceImpl implements SurveyService {
	@Resource
	private SurveyDao surveyDao;

	@Override
	public void create(Survey survey) {
		Date now = CalendarUtils.currentTime();
		survey.setCreateTime(now);
		survey.setUpdateTime(now);
		surveyDao.save(survey);
	}

	@Override
	public void update(Survey survey) {
		survey.setUpdateTime(CalendarUtils.currentTime());
		surveyDao.update(survey);
	}

	@Override
	public void delete(int surveyId) {
		Survey s = surveyDao.get(surveyId);
		s.setStatus(Survey.Status.Deleted.value());
		surveyDao.update(s);
	}

	@Override
	public void publish(int surveyId) {
		Survey s = surveyDao.get(surveyId);
		s.setStatus(Survey.Status.Published.value());
		s.setPublishTime(CalendarUtils.currentTime());
		surveyDao.update(s);
	}

	@Override
	public Survey getById(int surveyId) {
		return surveyDao.get(surveyId);
	}

	@Override
	public List<Survey> findAllSurvey() {
		return surveyDao.findAllSurvey();
	}
}