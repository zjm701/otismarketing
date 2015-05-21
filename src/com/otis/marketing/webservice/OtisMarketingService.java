package com.otis.marketing.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/otisService")
public interface OtisMarketingService {

	@GET
	@Path(value = "/sayHello")
	@Produces({ MediaType.APPLICATION_JSON })
	public String sayHello(@QueryParam("name") String name);
	
	@GET
	@Path(value = "/getNewsDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getNewsDetails(@QueryParam("newsId") String newsId);
	
	@GET
	@Path(value = "/getSurvey")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getSurveyById(@QueryParam("surveyId") String surveyId);
	
	@POST
	@Path(value = "/submitReply")
	@Consumes({ MediaType.APPLICATION_JSON })
	public String submitReply(String content);
	
	@GET
	@Path(value = "/transfer")
	@Produces({ MediaType.APPLICATION_JSON })
	public String transferBean(@QueryParam("content") String content);
	
	@GET
	@Path(value = "/viewNewsTime")
	@Produces({ MediaType.APPLICATION_JSON })
	public String viewNewsTime(@QueryParam("newsId") String newsId);
}
