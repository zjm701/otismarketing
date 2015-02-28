package com.otis.marketing.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/otisService")
public interface OtisSurveyService {

	@GET
	@Path(value = "/getSurvey")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getSurveyById(@QueryParam("surveyId") String surveyId);
	
	@POST
	@Path(value = "/submitReply")
	@Produces({ MediaType.APPLICATION_JSON })
	public String submitReply(@QueryParam("content") String content);
}
