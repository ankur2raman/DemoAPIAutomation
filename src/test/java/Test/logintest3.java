package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class logintest3 {
	
	@Test
	public void logintest(){
		LoginRequest loginrequest = new LoginRequest("ankur2raman", "Test1234");
	AuthService authservice = new AuthService();
	Response response = authservice.login(loginrequest);
	LoginResponse loginresponse = response.as(LoginResponse.class);
	
	System.out.println(response.asPrettyString());
	System.out.println(loginresponse.getToken());
	System.out.println(loginresponse.getEmail());
	
	Assert.assertTrue(loginresponse.getToken()!= null);
	Assert.assertEquals(loginresponse.getEmail(), "ankur.raman2112@gmail.com");
	
	}

}
