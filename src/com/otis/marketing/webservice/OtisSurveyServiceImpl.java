package com.otis.marketing.webservice;

import java.lang.reflect.Type;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.otis.marketing.entity.Survey;
import com.otis.marketing.service.SurveyService;
import com.otis.marketing.utils.Utils;

public class OtisSurveyServiceImpl implements OtisSurveyService {
	
	private static Logger logger = Logger.getLogger(OtisSurveyServiceImpl.class);
	
	public OtisSurveyServiceImpl() {
		logger.debug("In constructor");
	}
	
	@Autowired
	private SurveyService surveyService;

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
		JsonObject json = new JsonObject();
		try{
		}catch(Exception e){
			
		}
		return json.toString();
	}
	
	public static void main(String[] args) {
		
	}

}
