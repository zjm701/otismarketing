package com.otis.marketing.entity;

import java.io.Serializable;

public class StatisticItem implements Serializable {

	private String optionDesc;
	
	private long total;
	
	public StatisticItem(){
		
	}

	public String getOptionDesc() {
		return optionDesc;
	}

	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
