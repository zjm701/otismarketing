package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.web.dto.NewsBean;

public interface NewsService {

	public void addNews(NewsBean news);
	
	public List<NewsBean> getAllNews();
}
