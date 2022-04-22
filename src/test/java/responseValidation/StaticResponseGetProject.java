package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseGetProject 
{
	@Test
	public void staticResponseGet()
	{
		//Pre requisits
		String expData = "Avengers";
		baseURI="http://localhost:8084/";
		
		//perform action
		Response resp = when()
							.get("projects");
		
		//validation
		String actData = resp.jsonPath().get("[0].createdBy");
		Assert.assertEquals(actData, expData);
		System.out.println("Data Verified");
		
		resp.then().log().all();
	}
}
