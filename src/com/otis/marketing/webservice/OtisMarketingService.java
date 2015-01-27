package com.otis.marketing.webservice;

import javax.ws.rs.GET;
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
}
