package com.otis.marketing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.NewsDao;
import com.otis.marketing.entity.News;
import com.otis.marketing.security.OtisContext;
import com.otis.marketing.service.NewsService;
import com.otis.marketing.utils.CalendarUtils;
import com.otis.marketing.utils.Utils;
import com.otis.marketing.web.dto.NewsBean;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao;
	
	@Override
	public void addNews(NewsBean newsBean) {
		News news = new News();
		news.setContent(newsBean.getContent());
		news.setCreateTime(CalendarUtils.currentTime());
		news.setEnabled(1);
		news.setStatus(0); //0:new 1:published
		news.setTitle(newsBean.getTitle());
		news.setUpdateTime(CalendarUtils.currentTime());
		news.setUser(OtisContext.getContextUser());
		
		newsDao.saveNews(news);
	}

	@Override
	public List<NewsBean> getAllNews() {
		List<NewsBean> newsList = new ArrayList<NewsBean>();
		
		List<News> allNews = newsDao.findAllNews();
		
		for(News news : allNews) {
			NewsBean newsBean = new NewsBean();
			newsBean.setAuthorName(news.getUser().getUsername());
			//newsBean.setContent(news.getContent());
			newsBean.setCreateTime(Utils.formateDate(news.getCreateTime()));
			newsBean.setId(news.getId());
			newsBean.setStatus(news.getStatus());
			newsBean.setTitle(news.getTitle());
			newsBean.setUpdateTime(Utils.formateDate(news.getUpdateTime()));
			
			newsList.add(newsBean);
		}
		
		return newsList;
	}

	@Override
	public void updateNews(NewsBean news) {
		News ne = newsDao.findNewsById(news.getId());
		ne.setContent(news.getContent());
		ne.setUpdateTime(CalendarUtils.currentTime());
		ne.setTitle(news.getTitle());
		if (news.getStatus() != null) {
			ne.setStatus(news.getStatus());
		}
		
		newsDao.updateNews(ne);
	}
	
	@Override
	public void deleteNews(Integer newsId) {
		News news = newsDao.findNewsById(newsId);
		newsDao.deleteNews(news);
	}
	
	@Override
	public News getNewsById(Integer newsId) {
		return newsDao.findNewsById(newsId);
	}

	@Autowired
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

}