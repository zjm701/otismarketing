package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.google.gson.annotations.Expose;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_question")
public class Question implements Serializable {
	
	public static final String OPTION_DELIMITER = "ʃʃ";
	
	public static final Integer SINGLE_SELECTION_TYPE = 0;
	
	public static final Integer MULTI_SELECTION_TYPE = 1;
	
	public static final Integer SHORT_ANSWERS_TYPE = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "questionId")
	@Expose()
	private Integer questionId;

	@ManyToOne(optional = false, targetEntity = Survey.class)
	@Cascade({CascadeType.REFRESH})
	@JoinColumn(name = "surveyId", updatable = false)
	private Survey survey;

	@Column(name = "title", nullable = false, length = 100)
	@Expose()
	private String title;

	@Column(name = "description", length = 1000)
	@Expose()
	private String description;

	@Column(name = "type", nullable = false, updatable = false)
	@Expose()
	private Integer type;

	@Column(name = "isRequired", nullable = false)
	@Expose()
	private Integer isRequired;

	@Column(name = "orderNO", nullable = false)
	@Expose()
	private Integer orderNO;

	@Column(name = "optionsString", length = 1000)
	@Expose()
	private String optionsString;
	
	@Column(name = "linkRules", length = 1000)
	private String linkRules;

	public Question() {
	}
	
	public Question(Question q) {
		this.questionId = q.questionId;
		this.title = q.title;
		this.description = q.description;
		this.type = q.type;
		this.isRequired = q.isRequired;
		this.orderNO = q.orderNO;
		this.optionsString = q.optionsString;
		this.linkRules = q.linkRules;
	}

	public Question(String title) {
		this(title, Type.Single.value());
	}

	public Question(String title, int type) {
		this.title = title;
		this.description = "";
		this.type = type;
		this.isRequired = IsRequired.No.value();
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Integer isRequired) {
		this.isRequired = isRequired;
	}

	public Integer getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(Integer orderNO) {
		this.orderNO = orderNO;
	}

	public String getOptionsString() {
		return optionsString;
	}

	public void setOptionsString(String optionsString) {
		this.optionsString = optionsString;
	}

	public String getLinkRules() {
		return linkRules;
	}

	public void setLinkRules(String linkRules) {
		this.linkRules = linkRules;
	}

	public enum Type {
		Single(0), Multiple(1), Question(2);

		private int value;

		private Type(int value) {
			this.value = value;
		}

		public Integer value() {
			return value;
		}
	}

	public enum IsRequired {
		No(0), Yes(1);

		private int value;

		private IsRequired(int value) {
			this.value = value;
		}

		public Integer value() {
			return value;
		}
	}
	
	public Map<Integer, Option> splitOptionString() {
		Map<Integer, Option> result = new HashMap<Integer, Option>();
		if(!org.springframework.util.StringUtils.isEmpty(getOptionsString())){
			String[] options = getOptionsString().split(Question.OPTION_DELIMITER);
			int index = 0;
			for (String desc : options){
				Option option = new Option();
				option.setIndex(index ++);
				option.setDescription(desc);
				result.put(option.getIndex(), option);
			}
		}
		return result;
	}
}
