package com.api.base;

import com.api.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {
	
	private static final String BASE_PATH = "/api/users";
	
	public Response getprofile(String token) {
		setAuthtoken(token);
		return getrequest(BASE_PATH+"/profile");
	}
	
	public Response updateprofile(String token, ProfileRequest payload) {
		setAuthtoken(token);
		return putrequest(payload, BASE_PATH+"/profile");
	}

}
