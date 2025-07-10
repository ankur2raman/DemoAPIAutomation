package com.api.base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	private static final String BASE_PATH = "/api/auth/";
	
	public Response login(LoginRequest payload) {
		return postrequest(payload, BASE_PATH+"login");
	
		
	}
	
	public Response signup(SignupRequest payload) {
		return postrequest(payload, BASE_PATH+"signup");
	
		
	}
	
	public Response forgotPassword(String emailAddress) {
		HashMap<String, String> payload = new HashMap();
		payload.put("email", emailAddress);
		return postrequest(payload, BASE_PATH+"forgot-password");
		
	}
	

}
