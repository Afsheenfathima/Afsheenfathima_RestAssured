package differentWaysToPOST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFile 
{
	@Test
	public void createProject()
	{
		//Step 1: create pre requisits
		File file= new File(".\\Sample.json");
		
		baseURI ="http://localhost:8084/";
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
		
		.when()					//Step 2: perform action
			.post("addProject")
		
		.then()					//Step 3: validate
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
	}
}
