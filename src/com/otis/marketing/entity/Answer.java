package com.otis.marketing.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_answer")
public class Answer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "answerId")
	private Integer answerId;
	
	@ManyToOne(optional = false, targetEntity = Reply.class)
	@Cascade({org.hibernate.annotations.CascadeType.REFRESH})
	@JoinColumn(name = "replyId", updatable = false)
	private Reply reply;
	
	@OneToOne(cascade = { CascadeType.ALL }, optional = false)
	@JoinColumn(name = "questionId")
	private Question question;
	
	@Column(name = "intValue")
	private Integer intValue;
	
	@Column(name = "stringValue", length = 1000)
	private String stringValue;
	
	public Answer(){
		
	}
	
	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getIntValue() {
		return intValue;
	}

	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

}
