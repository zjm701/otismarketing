package com.otis.marketing.web.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.otis.marketing.service.SurveyService;

@SuppressWarnings("serial")
@Scope("request")
@Controller("surveyAction")
public class SurveyAction extends ActionSupport {

	private static Logger logger = Logger.getLogger(SurveyAction.class);

	@Autowired
	private SurveyService surveyService;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String create() throws Exception {
		return SUCCESS;
	}

	public String findAllSurvey() throws Exception {
		return "list";
	}
}
