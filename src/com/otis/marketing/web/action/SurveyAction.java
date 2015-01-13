package com.otis.marketing.web.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.Survey;
import com.otis.marketing.entity.Users;
import com.otis.marketing.service.SurveyService;
import com.otis.marketing.utils.CalendarUtils;

@SuppressWarnings("serial")
@Scope("request")
@Controller("surveyAction")
public class SurveyAction extends BaseAction {

	private static Logger logger = Logger.getLogger(SurveyAction.class);

	@Autowired
	private SurveyService surveyService;

	private String title;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String toAdd() throws Exception {
		return SUCCESS;
	}

	public String add() throws Exception {
		Survey s = new Survey();
		s.setTitle(title);
		s.setStatus(0);
		s.setAuthorId(((Users) getSession().get("user")).getId());
		s.setCreateTime(CalendarUtils.currentTime());
		surveyService.create(s);
		getSession().put("currentSurvey", s);
		return SUCCESS;
	}

	public String findAllSurvey() throws Exception {
		List<Survey> list = surveyService.findAllSurvey();
		getSession().put("AllSurvey", list);
		return "list";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
