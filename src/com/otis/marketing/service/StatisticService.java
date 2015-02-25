package com.otis.marketing.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.otis.marketing.entity.Statistic;

public interface StatisticService {

	public List<Statistic> getSurveyStatistic(Integer surveyId);
	
	public void exportBySurvey(HttpServletResponse response, Integer surveyId) throws Exception;
	
	public void exportByQuestion(HttpServletResponse response, Integer surveyId, Integer index) throws Exception;
}
