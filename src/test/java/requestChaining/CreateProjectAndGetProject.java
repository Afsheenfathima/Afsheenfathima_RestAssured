package requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

public class CreateProjectAndGetProject 
{
	@Test
	public void requestChaining1()
	{
		//Create a project using POJO
		
		JavaLibrary jLib= new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary("Aaira", "CEO"+jLib.getRandomNumber(), "On Going", 1);
		baseURI = "http://localhost:8084/";
		
		Response resp = given()
							.body(pLib)
							.contentType(ContentType.JSON)
			
						.when()
							.post("addProject");
		
		//Capture ProjectId
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//Create a get request and pass proId as path parameter
		given()
			.pathParam("pid", proId)
		
		.when()
			.get("projects/{pid}")
			
		.then()
			.assertThat().statusCode(200)
			.log().all();	
		
	}
}
