package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("serial")
//@Entity
public class Statistic implements Serializable{
	private String title;
	
	private List<StatisticItem> items = new ArrayList<StatisticItem>();

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
}
