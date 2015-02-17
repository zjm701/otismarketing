package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.entity.Statistic;

public interface StatisticService {

	public List<Statistic> getSurveyStatistic(Integer surveyId);
}
