package com.otis.marketing.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otis.marketing.entity.News;

public interface NewsDao {
	
	public void saveUser(News news) throws DataAccessException;
	
	public List<News> findAllNews() throws DataAccessException;
	
	public News findNewsById(Integer newsId) throws DataAccessException;
}
