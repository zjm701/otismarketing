package com.otis.marketing.webservice;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.otis.marketing.entity.Answer;
import com.otis.marketing.entity.News;
import com.otis.marketing.entity.Question;
import com.otis.marketing.entity.Reply;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.json.bean.AnswerJson;
import com.otis.marketing.json.bean.ReplyJson;
import com.otis.marketing.service.NewsService;
import com.otis.marketing.service.ReplyService;
import com.otis.marketing.service.SurveyService;
import com.otis.marketing.utils.Utils;

public class OtisMarketingServiceImpl implements OtisMarketingService {
	
	private static Logger logger = Logger.getLogger(OtisMarketingServiceImpl.class);

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private ReplyService replyService;
	
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
	public String transferBean(String content) {
		try{
			Gson gson = new Gson();
			ReplyJson replyJson = gson.fromJson(content, ReplyJson.class);
			Reply reply = new Reply();
			reply.setUserKey(replyJson.getUserKey());
			reply.setUserName(replyJson.getUserName());
			reply.setCreateTime(new Date());
			reply.setSurvey(surveyService.getById(replyJson.getSurveyId()));
			List<Answer> answers = new ArrayList<Answer>();
			for (AnswerJson anJson : replyJson.getAnswers()) {
				Answer an = new Answer();
				Question question = replyService.getQuestionById(anJson.getQuestionId());
				if (question != null) {
					an.setQuestion(question);
					an.setReply(reply);
					switch (question.getType()) {
					case 0:
						an.setIntValue(Integer.parseInt(anJson.getValue()));
						break;
					case 1:
						for (Integer value : anJson.getAllValues()) {
							Answer anMulti = new Answer();
							anMulti.setQuestion(question);
							anMulti.setIntValue(value);
							anMulti.setReply(reply);
							answers.add(anMulti);
						};
						break;
					case 2:
						an.setStringValue(anJson.getValue());
						break;
					}
				}
				answers.add(an);
			}
			reply.setAnswers(answers);
			replyService.saveReply(reply);
			return getSuccessfulJsonResult();
		} catch (Exception e) {
			logger.debug(e);
			return getFailedJsonResult();
		}
		
	}
	
	@Override
	public String submitReply(String content) {
		return transferBean(content);
	}
	
	private String getSuccessfulJsonResult() {
		return "{\"result\":\"successful\"}";
	}
	
	private String getFailedJsonResult() {
		return "{\"result\":\"failed\"}";
	}
}
