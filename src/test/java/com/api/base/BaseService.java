package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.request.LoginRequest;
import filters.loggingfilter;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
//wrapper for RestAssured
	//creating request
	//handling response 
	
	private static final String BASE_URL= "http://64.227.160.186:8080"; // base url is constant hence private static final
	private RequestSpecification requestSpecification ;
	
	static {
		RestAssured.filters(new loggingfilter());
	}
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthtoken(String token) {
		requestSpecification.header("Authorization", "Bearer "+token);
	}
	
	//protected Response postrequest(LoginRequest payload, String endpoint) use Object instead , now this method becomes loosely coupled
	protected Response postrequest(Object payload, String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response putrequest(Object payload, String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	
	protected Response getrequest(String endpoint)
	{
		return requestSpecification.get(endpoint);
	}
}
