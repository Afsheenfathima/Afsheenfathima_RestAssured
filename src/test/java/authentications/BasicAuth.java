package authentications;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuth
{
	@Test
	public void basicAuth()
	{
		baseURI="http://localhost:8084/";
		
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
			
		.when()
			.get("login")
			
		.then()
			.assertThat().statusCode(202)
			.log().all();
	}
	
	@Test
	public void basicPreEmptiveAuth()
	{
		baseURI="http://localhost:8084/";
		
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
			
		.when()
			.get("login")
			
		.then()
			.assertThat().statusCode(202)
			.log().all();
	}
	
	@Test
	public void basicDigestiveAuth()
	{
		baseURI="http://localhost:8084/";
		
		given()
			.auth().digest("rmgyantra", "rmgy@9999")
			
		.when()
			.get("login")
			
		.then()
			.assertThat().statusCode(202)
			.log().all();
	}
}
