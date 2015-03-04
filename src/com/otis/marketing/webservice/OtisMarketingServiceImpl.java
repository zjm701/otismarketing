package com.otis.marketing.webservice;

import java.lang.reflect.Type;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.otis.marketing.entity.News;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.service.NewsService;
import com.otis.marketing.service.SurveyService;
import com.otis.marketing.utils.Utils;

public class OtisMarketingServiceImpl implements OtisMarketingService {

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private SurveyService surveyService;
	
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
	
	@Override
	public String getSurveyById(String surveyId) {
		Survey survey = surveyService.getById(Integer.parseInt(surveyId));
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		builder.serializeNulls();
		builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>(){
			public JsonElement serialize(Date date, Type type,  
	                JsonSerializationContext arg2) {  
	                return new JsonPrimitive(Utils.formateDate(date));
	        }
		});
		Gson gson = builder.create();
		return gson.toJson(survey);
	}
	
	@Override
	public String submitReply(String content) {
		try{
		}catch(Exception e){
			return getFailedJsonResult();
		}
		return getSuccessfulJsonResult();
	}
	
	private String getSuccessfulJsonResult() {
		return "{\"result\":\"successful\"}";
	}
	
	private String getFailedJsonResult() {
		return "{\"result\":\"failed\"}";
	}
}
