package com.otis.marketing.webservice;

public class OtisMarketingServiceImpl implements OtisMarketingService {

	@Override
	public String sayHello(String name) {
		return "{\"name\":\"" + name + "\",\"action\":\"hello\"}";
	}

}
