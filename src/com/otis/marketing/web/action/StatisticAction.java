package com.otis.marketing.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otis.marketing.entity.Answer;
import com.otis.marketing.entity.Question;
import com.otis.marketing.entity.Reply;
import com.otis.marketing.entity.Statistic;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.service.ReplyService;
import com.otis.marketing.service.StatisticService;
import com.otis.marketing.service.SurveyService;

@SuppressWarnings("serial")
@Scope("request")
@Controller("statisticAction")
public class StatisticAction extends BaseAction implements ServletResponseAware{
	private static Logger logger = Logger.getLogger(StatisticAction.class);
	private static String dateformatString = "yyyy-MM-dd HH:mm:ss";

	private static DateFormat df = null;

	private static Gson gson = null;
	
	private HttpServletResponse response;

	static {
		df = new SimpleDateFormat(dateformatString);
		gson = new GsonBuilder().setDateFormat(dateformatString).create();
	}
	
	private Integer surveyId;
	
	private Integer index;
	
	private List<Statistic> statList;
	
	@Autowired
	private StatisticService statisticService;
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private ReplyService replyService;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String getSurveyStatistic() {
		statList = statisticService.getSurveyStatistic(surveyId);
		getSession().put("currentStatList", statList);
		return SUCCESS;
	}
	
	public String exportSurveyStatistic() {
		try{
			if(index == null){
				//导出所有统计结果
				statisticService.exportBySurvey(response, surveyId);
			}else{
				statisticService.exportByQuestion(response, surveyId, index);
			}
			
			return SUCCESS;
		} catch (Exception e) {
			logger.debug(e);
			return ERROR;
		}
	}
	
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
