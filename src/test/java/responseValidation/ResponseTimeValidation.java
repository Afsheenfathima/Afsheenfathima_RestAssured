package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation
{
	@Test
	public void responseValidation()
	{
		//Pre requisits
		baseURI = "http://localhost:8084/";
		
		//actions
		Response resp = when()
							.get("projects");
			
		//validation	
		resp.then()
				.assertThat()
				.time(Matchers.greaterThan(10L),TimeUnit.MILLISECONDS)
				.log().all();
		
		//for printing time in console
		long ti = resp.time();
		System.out.println(ti);		
	}
}
