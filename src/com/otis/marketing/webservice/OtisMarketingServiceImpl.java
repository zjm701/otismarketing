package com.otis.marketing.webservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;
import com.otis.marketing.entity.News;
import com.otis.marketing.service.NewsService;
import com.otis.marketing.utils.Utils;

public class OtisMarketingServiceImpl implements OtisMarketingService {

	@Autowired
	private NewsService newsService;
	
	@Override
	public String sayHello(String name) {
		return "{\"name\":\"" + name + "\",\"action\":\"hello\"}";
	}

	@Override
	public String getNewsDetails(String newsId) {
		
		News news = null;
		if(newsId != null) {
			news = newsService.getNewsById(Integer.valueOf(newsId));
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("title", news.getTitle());
		json.addProperty("content", news.getContent());
		json.addProperty("createTime", Utils.formateDateTime(news.getCreateTime()));
		
		return json.toString();
	}
}
