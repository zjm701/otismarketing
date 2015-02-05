package com.otis.marketing.entity;

import java.io.Serializable;

public class StatisticItem implements Serializable {

	private String optionDesc;
	
	private int total;
	
	public StatisticItem(){
		
	}

	public String getOptionDesc() {
		return optionDesc;
	}

	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
