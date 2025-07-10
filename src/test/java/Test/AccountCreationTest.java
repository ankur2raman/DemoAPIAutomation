package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test
	public void createAccountTest() {
		
		SignupRequest signupRequest=new SignupRequest.Builder().username("ankur4raman")
		 .email("abcdeankur@gmail.com")
		 .firstName("ankur")
		 .lastName("raman")
		 .mobileNumber("9999999999")
		 .password("ankur4raman").build();
		
		
		AuthService authservice = new AuthService();
		Response response = authservice.signup(signupRequest);
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
	}

}
