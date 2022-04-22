package differentWaysToPOST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap
{
	@Test
	public void createProjectTest()
	{
		JavaLibrary jLib= new JavaLibrary();
		
		//Step 1: create pre requisits
		HashMap map = new HashMap();
		map.put("createdBy", "Afsheen");
		map.put("projectName", "ABC "+jLib.getRandomNumber());
		map.put("status", "Completed");
		map.put("teamSize", 20);
		
		baseURI ="http://localhost:8084/";
		
		given()
			.body(map)
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
