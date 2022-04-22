package CrudOperationWidBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjectTest 
{
	@Test
	public void getAllProjectTest()
	{
		//step 1: create pre requisits
		baseURI = "http://localhost:8084/";
		
		//Step 2: actions
		when()
			.get("projects")
		
		.then()		//Step 3: validate        
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}
}
