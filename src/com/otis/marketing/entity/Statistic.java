package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Statistic implements Serializable{
	private String title;
	
	private String optionString;
	
	private String totalString;
	
	private List<StatisticItem> items = new ArrayList<StatisticItem>();
	
	public Statistic(){
		optionString = "";
		totalString = "";
	}
	
	public void build4UI() {
		for (StatisticItem item : getItems()) {
			optionString += "'" + item.getOptionDesc() + "',";
			totalString += item.getTotal() + ",";
		}
		optionString = optionString.substring(0, optionString.lastIndexOf(","));
		totalString = totalString.substring(0, totalString.lastIndexOf(","));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<StatisticItem> getItems() {
		return items;
	}

	public void setItems(List<StatisticItem> items) {
		this.items = items;
	}
	public void addItem(StatisticItem item) {
		items.add(item);
	}

	public String getOptionString() {
		return optionString;
	}

	public void setOptionString(String optionString) {
		this.optionString = optionString;
	}

	public String getTotalString() {
		return totalString;
	}

	public void setTotalString(String totalString) {
		this.totalString = totalString;
	}
}
