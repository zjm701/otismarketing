package com.otis.marketing.web.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.Question;
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

	private String qusetion1;

	private String qusetion1_option1;

	private String qusetion1_link1;

	private String qusetion1_option2;

	private String qusetion1_link2;

	private String qusetion2;

	private String qusetion3;

	private String qusetion4;

	private String qusetion4_option1;

	private String qusetion4_option2;

	private String qusetion4_option3;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String toAdd() throws Exception {
		return SUCCESS;
	}

	public String add() throws Exception {
		Survey s = new Survey(title);
		s.setAuthor((Users) getSession().get("user"));
		
		Question q1 = new Question(qusetion1);
		q1.setOptionsString("-" + qusetion1_option1 + "-" + qusetion1_option2 + "-" );
		q1.setLinkRules("-" + qusetion1_link1 + "-" + qusetion1_link2 + "-" );
		
		Question q2 = new Question(qusetion2);
		q2.setType(Question.Type.Multiple.getValue());

		Question q3 = new Question(qusetion3);
		q3.setType(Question.Type.Multiple.getValue());

		Question q4 = new Question(qusetion4);
		q4.setType(Question.Type.Question.getValue());
		q4.setOptionsString("-" + qusetion4_option1 + "-" + qusetion4_option2 + "-" + qusetion4_option3 + "-");

		s.addQuestion(q1);
		s.addQuestion(q2);
		s.addQuestion(q3);
		s.addQuestion(q4);

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

	public String getQusetion1() {
		return qusetion1;
	}

	public void setQusetion1(String qusetion1) {
		this.qusetion1 = qusetion1;
	}

	public String getQusetion1_option1() {
		return qusetion1_option1;
	}

	public void setQusetion1_option1(String qusetion1_option1) {
		this.qusetion1_option1 = qusetion1_option1;
	}

	public String getQusetion1_link1() {
		return qusetion1_link1;
	}

	public void setQusetion1_link1(String qusetion1_link1) {
		this.qusetion1_link1 = qusetion1_link1;
	}

	public String getQusetion1_option2() {
		return qusetion1_option2;
	}

	public void setQusetion1_option2(String qusetion1_option2) {
		this.qusetion1_option2 = qusetion1_option2;
	}

	public String getQusetion1_link2() {
		return qusetion1_link2;
	}

	public void setQusetion1_link2(String qusetion1_link2) {
		this.qusetion1_link2 = qusetion1_link2;
	}

	public String getQusetion2() {
		return qusetion2;
	}

	public void setQusetion2(String qusetion2) {
		this.qusetion2 = qusetion2;
	}

	public String getQusetion3() {
		return qusetion3;
	}

	public void setQusetion3(String qusetion3) {
		this.qusetion3 = qusetion3;
	}

	public String getQusetion4() {
		return qusetion4;
	}

	public void setQusetion4(String qusetion4) {
		this.qusetion4 = qusetion4;
	}

	public String getQusetion4_option1() {
		return qusetion4_option1;
	}

	public void setQusetion4_option1(String qusetion4_option1) {
		this.qusetion4_option1 = qusetion4_option1;
	}

	public String getQusetion4_option2() {
		return qusetion4_option2;
	}

	public void setQusetion4_option2(String qusetion4_option2) {
		this.qusetion4_option2 = qusetion4_option2;
	}

	public String getQusetion4_option3() {
		return qusetion4_option3;
	}

	public void setQusetion4_option3(String qusetion4_option3) {
		this.qusetion4_option3 = qusetion4_option3;
	}
}
