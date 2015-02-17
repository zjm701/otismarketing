package com.otis.marketing.dao;

import java.util.List;

import com.otis.marketing.entity.Statistic;

public interface StatisticDao {

	public List<Statistic> getSurveyStatistic(Integer surveyId);
}
