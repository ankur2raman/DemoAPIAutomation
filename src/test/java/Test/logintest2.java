package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class logintest2 {
	@Test(description = "verify login")
	public void logintest() {
			
		Response response = given()
	            .baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json")
				.body("{\"username\": \"ankur2raman\",\"password\": \"Test1234\"}")
				.post("/api/auth/login");
	
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}

