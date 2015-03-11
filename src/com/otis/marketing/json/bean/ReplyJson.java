package com.otis.marketing.json.bean;

import java.util.List;

public class ReplyJson {

	private Integer surveyId;
	
	private String userName;
	
	private String userKey;
	
	private List<AnswerJson> answers;

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public List<AnswerJson> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerJson> answers) {
		this.answers = answers;
	}
}
