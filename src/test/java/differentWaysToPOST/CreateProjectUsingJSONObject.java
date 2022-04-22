package differentWaysToPOST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObject 
{
	@Test
	public void createProjectTest()
	{
		JavaLibrary jLib = new JavaLibrary();
		
		//Step 1: create pre requisits
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Afsheen");
		jObj.put("projectName", "MNOPQ "+jLib.getRandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		baseURI ="http://localhost:8084/";
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		
		.when()			//Step 2: perform action
			.post("addProject")
		
		.then()			//Step 3: validate
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
	}
}
