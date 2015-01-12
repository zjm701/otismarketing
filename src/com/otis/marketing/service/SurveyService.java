package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.entity.Survey;

public interface SurveyService {

	public void create(Survey survey);

	public void update(Survey survey);

	public void delete(int surveyId);

	public Survey getById(int id);

	public List<Survey> findAllSurvey();

}