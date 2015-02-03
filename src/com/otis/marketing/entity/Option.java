package com.otis.marketing.entity;

import java.io.Serializable;

public class Option implements Serializable {
	
	private int index;
	
	private String description;
	
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

}
