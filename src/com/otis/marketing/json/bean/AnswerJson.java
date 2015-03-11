package com.otis.marketing.json.bean;

import java.util.ArrayList;
import java.util.List;

public class AnswerJson {

	private Integer questionId;
	
	private String value;
	
	private List<Value> values;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	protected List<Value> getValues() {
		return values;
	}
	
	public List<Integer> getAllValues() {
		List<Integer> list = new ArrayList<Integer>();
		for (Value value : getValues()) {
			list.add(value.getValue());
		}
		return list;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}
	
}

class Value {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}