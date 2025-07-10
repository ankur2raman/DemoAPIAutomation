package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateprofiletest() {
		AuthService authservice = new AuthService();
		Response response = authservice.login(new LoginRequest("ankur2raman", "Test1234"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println("...............");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getprofile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class); //desrialise
		Assert.assertEquals(userProfileResponse.getEmail(), "ankur.raman2112@gmail.com" );
		System.out.println("...............");
		
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Akanksha")
			    .lastName("Adhrit")
			    .email("ankur.raman2112@gmail.com")
			    .mobileNumber("9999999999")
			    .build();

				
		response = userProfileManagementService.updateprofile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse1 = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse1.getFirstName());
		
	}

}
