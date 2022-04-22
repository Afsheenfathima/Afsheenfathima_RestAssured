package authentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 
{
	@Test
	public void oauthAuthentication()
	{
		//Create a request to generate access token
		Response resp = given()
							.formParam("client_id", "SDET_30CoopsAPIAfsheen")					//copy and paste everything in notepad ie., client_i, client_secret etc
							.formParam("client_secret", "8ad9d319e7248f4689794d04fa9b2067")
							.formParam("grant_type", "client_credentials")
							.formParam("redirect_uri", "http://example.com")
							.formParam("code", "authorization_code")
			
						.when()
							.post("http://coop.apps.symfonycasts.com/token");
		
		//Capure the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");			
		System.out.println(token);
		
		//create another request and use the token to access the APIs
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID",3107)				//USER_ID will be in the application of coops
			
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")			//write USER_ID in curly braces ie.,{USER_ID}
			
		.then()
			.log().all();
	}
}
