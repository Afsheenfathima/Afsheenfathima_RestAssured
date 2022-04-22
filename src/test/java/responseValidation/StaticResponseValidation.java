package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation 
{
	@Test
	public void staticResponse()
	{
		//Step 1: pre requisits
		
		String expData = "TY_PROJ_1405";
		JavaLibrary jLib= new JavaLibrary();
		
		ProjectLibrary pLib= new ProjectLibrary("Afsheen", "Aaira "+jLib.getRandomNumber(), "Completed", 2);
		
		baseURI="http://localhost:8084/";
		
		Response resp = given()
							.body(pLib)
							.contentType(ContentType.JSON)
			
		.when()					//Step 2: perform action
			.post("addProject");
		
		//Step 3: validation
		
		String actData = resp.jsonPath().get("projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("Data Verified");
		
		resp.then().log().all();
		
		
		
	}
	
}
