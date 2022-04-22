package CrudOperationWidBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		//Step 1: create pre requisits
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Afsheen");
		jObj.put("projectName", "MNOPQ");
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
