package Test;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class forgotpasswordtest {
	
	@Test
	public void forgotpasswordtest() {
		AuthService authservice = new AuthService();
		Response response = authservice.forgotPassword("ankur.raman2112@gmail.com");
		System.out.println(response.asPrettyString());
		
		
	}

}
