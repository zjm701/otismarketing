package com.otis.marketing.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.otis.marketing.entity.Question;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.entity.Users;
import com.otis.marketing.service.SurveyService;

@SuppressWarnings("serial")
@Scope("request")
@Controller("surveyAction")
public class SurveyAction extends BaseAction {

	private static Logger logger = Logger.getLogger(SurveyAction.class);

	private static Gson gson = new Gson();

	private static DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

	@Autowired
	private SurveyService surveyService;

	private String surveyJson;

	private int surveyId;

	private String message;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String toAdd() throws Exception {
		return SUCCESS;

	}

	public String add() throws Exception {
		JSONObject json = new JSONObject(surveyJson);

		Survey s = new Survey(json.getString("title"));
		s.setDescription(json.getString("description"));
		if (json.getString("startTime") != "") {
			s.setStartTime(df.parse(json.getString("startTime")));
		}
		if (json.getString("endTime") != "") {
			s.setEndTime(df.parse(json.getString("endTime")));
		}
		s.setAuthor((Users) getSession().get("user"));

		JSONArray questions = json.getJSONArray("questions");

		for (int i = 0; i < questions.length(); i++) {
			JSONObject q = (JSONObject) questions.get(i);
			Question question = new Question(q.getString("title"));
			question.setType(q.getInt("type"));
			question.setIsRequired(q.getInt("isRequired"));
			question.setOrderNO(q.getInt("orderNO"));
			question.setOptionsString(q.getString("optionsString"));
			question.setLinkRules(q.getString("linksString"));
			s.addQuestion(question);
		}

		surveyService.create(s);

		getSession().put("currentSurvey", s);
		this.message = "新增成功，标题为：" + s.getTitle();
		return SUCCESS;
	}

	public String delete() throws Exception {
		surveyService.delete(surveyId);
		this.message = "删除成功!";
		return SUCCESS;
	}

	public String publish() throws Exception {
		surveyService.publish(surveyId);
		this.message = "发布成功!";
		return SUCCESS;
	}

	public String findAllSurvey() throws Exception {
		List<Survey> list = surveyService.findAllSurvey();
		getSession().put("AllSurvey", list);
		return "list";
	}

	public String getSurveyJson() {
		return surveyJson;
	}

	public void setSurveyJson(String surveyJson) {
		this.surveyJson = surveyJson;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
