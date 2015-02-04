package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_survey")
public class Survey implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "surveyId")
	private Integer surveyId;

	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Column(name = "description", length = 1000)
	private String description;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "type")
	private Integer type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime")
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateTime")
	private Date updateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publishTime")
	private Date publishTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startTime")
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endTime")
	private Date endTime;

	@ManyToOne(cascade = { CascadeType.REFRESH }, optional = true, targetEntity = Users.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "authorId")
	private Users author;

	@OneToMany(mappedBy = "survey", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@OrderBy(value = "orderNO ASC")
	private List<Question> questions = new ArrayList<>();

	public Survey() {
	}
	
	public Survey(Survey s){
		this.surveyId = s.surveyId;
		this.title = s.title;
		this.description = s.description;
		this.status = s.status;
		this.type = s.type;
		this.createTime = s.createTime;
		this.updateTime = s.updateTime;
		this.publishTime = s.publishTime;
		this.startTime = s.startTime;
		this.endTime = s.endTime;
		this.author = new Users(s.getAuthor().getUsername());
		this.questions = s.copyQuestions();
	}

	public Survey(String title) {
		this.title = title;
		this.status = Status.New.value();
		this.type = Type.Default.value();
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void addQuestion(Question question) {
		question.setOrderNO(this.questions.size() + 1);
		question.setSurvey(this);
		this.questions.add(question);
	}
	
	public List<Question> copyQuestions(){
		List<Question> questions = new ArrayList<>();
		for(Question q : this.getQuestions()){
			questions.add(new Question(q));
		}
		return questions;
	}

	public enum Status {
		New(0), Published(1), End(2), Deleted(-1);

		private int value;

		private Status(int value) {
			this.value = value;
		}

		public Integer value() {
			return value;
		}
	}

	public enum Type {
		Default(0);

		private int value;

		private Type(int value) {
			this.value = value;
		}

		public Integer value() {
			return value;
		}
	}
}
