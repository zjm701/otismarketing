package com.otis.marketing.entity;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option implements Serializable {
	
	@Expose
	@SerializedName("orderNO")
	private int index;
	
	@Expose
	private String description;
	
	@Expose
	private int nextQuestionNo;
	
	public Option(){
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNextQuestionNo() {
		return nextQuestionNo;
	}

	public void setNextQuestionNo(int nextQuestionNo) {
		this.nextQuestionNo = nextQuestionNo;
	}


}
