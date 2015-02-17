package com.otis.marketing.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otis.marketing.entity.Statistic;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.service.StatisticService;
import com.otis.marketing.service.SurveyService;

@SuppressWarnings("serial")
@Scope("request")
@Controller("statisticAction")
public class StatisticAction extends BaseAction {
	private static Logger logger = Logger.getLogger(StatisticAction.class);
	private static String dateformatString = "yyyy-MM-dd HH:mm:ss";

	private static DateFormat df = null;

	private static Gson gson = null;

	static {
		df = new SimpleDateFormat(dateformatString);
		gson = new GsonBuilder().setDateFormat(dateformatString).create();
	}
	
	private Integer surveyId;
	
	private List<Statistic> statList;
	
	@Autowired
	private StatisticService statisticService;
	
	@Autowired
	private SurveyService surveyService;

	
	public String getSurveyStatistic() {
		statList = statisticService.getSurveyStatistic(surveyId);
		getSession().put("currentStatList", statList);
		return SUCCESS;
	}
	public String findAllSurvey() {
		List<Survey> list = surveyService.findAllSurvey();
		getSession().put("AllSurvey", list);
		return "list";
	}
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
}
