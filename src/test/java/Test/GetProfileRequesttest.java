package Test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequesttest {
	
	@Test
	public void getprofileInfo() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("ankur2raman", "Test1234"));
		LoginResponse loginresponse = response.as(LoginResponse.class); //deserialization
		System.out.println(loginresponse.getToken());
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getprofile(loginresponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class); // Deserialisation
		System.out.println(userProfileResponse.getUsername());
		System.out.println(userProfileResponse.getFirstName());
		
	}

}
