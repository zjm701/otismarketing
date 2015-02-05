package com.otis.marketing.web.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.service.StatisticService;

@SuppressWarnings("serial")
@Scope("request")
@Controller("statisticAction")
public class StatisticAction extends BaseAction {
	private static Logger logger = Logger.getLogger(StatisticAction.class);

	@Autowired
	private StatisticService statisticService;
	
	public String getSurveyStatistic(){
//		statisticService.getSurveyStatistic();
		return SUCCESS;
	}
}
