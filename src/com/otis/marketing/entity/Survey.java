package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Temporal(TemporalType.TIME)
	@Column(name = "updateTime")
	private Date updateTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "publishTime")
	private Date publishTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "startTime")
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "endTime")
	private Date endTime;

	@Column(name = "authorId", nullable = false)
	private Integer authorId;

	// @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
	// targetEntity = User.class)
	// @JoinColumn(name = "authorId")
	// private User user;

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

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}
