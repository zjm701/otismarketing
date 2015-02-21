package com.otis.marketing.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.News;
import com.otis.marketing.service.NewsService;
import com.otis.marketing.web.dto.NewsBean;

@Scope("request")
@Controller("newsAction")
public class NewsAction extends BaseAction {

	private static final long serialVersionUID = -1557654686550631734L;

	private static Logger logger = Logger.getLogger(NewsAction.class);

	private String title;

	private String content;

	private Integer status;

	private Integer newsId;

	private List<NewsBean> data = new ArrayList<NewsBean>();

	@Autowired
	private NewsService newsService;

	public String getNewsInfoList() {
		List<NewsBean> newsList = newsService.getAllNews();
		data.addAll(newsList);

		return "newsInfos";
	}

	public String addNews() {
		NewsBean news = new NewsBean();
		news.setContent(content);
		news.setTitle(title);

		newsService.addNews(news);

		return SUCCESS;
	}

	public String initUpdate() {

		News news = newsService.getNewsById(newsId);
		this.title = news.getTitle();
		this.content = news.getContent();

		return SUCCESS;
	}

	public String previewNews() {
		
		News news = newsService.getNewsById(newsId);
		this.title = news.getTitle();
		this.content = news.getContent();
		return SUCCESS;
	}
	
	public String updateNews() {
		NewsBean news = new NewsBean();
		news.setContent(content);
		news.setTitle(title);
		news.setId(newsId);

		newsService.updateNews(news);
		
		return SUCCESS;
	}

	public String deleteNews() {
		newsService.deleteNews(newsId);
		
		return SUCCESS;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<NewsBean> getData() {
		return data;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

}
