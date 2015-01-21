package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_reply")
public class Reply implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "replyId")
	private Integer replyId;
	
	@Column(name = "userKey", length = 100)
	private String userKey;
	
	@Column(name = "userName", length = 100)
	private String userName;
	
	@OneToOne(cascade = { CascadeType.ALL }, optional = false)
	@JoinColumn(name = "surveyId")
	private Survey survey;
	
	@Column(name = "createTime")
	private Date createTime;
	
	public Reply(){
		
	}
	
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
