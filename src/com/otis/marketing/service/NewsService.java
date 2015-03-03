package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.entity.News;
import com.otis.marketing.web.dto.NewsBean;

public interface NewsService {

	public void addNews(NewsBean news);
	
	public List<NewsBean> getAllNews();
	
	public News getNewsById(Integer newsId);
	
	public void updateNews(NewsBean news);
	
	public void deleteNews(Integer newsId);
	
	public void publishNews(Integer newsId);
}
