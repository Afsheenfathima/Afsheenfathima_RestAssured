package CrudOperationWidBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest
{
	@Test
	public void updateProjectTest()
	{
		//Step 1: create pre requisits
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Afsheenfathima");
		jObj.put("projectName", "MNOPQ");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
				
		baseURI ="http://localhost:8084/";
				
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
				
		.when()			//Step 2: perform action
			.put("projects/TY_PROJ_1205")
				
		.then()			//Step 3: validate
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}
}
