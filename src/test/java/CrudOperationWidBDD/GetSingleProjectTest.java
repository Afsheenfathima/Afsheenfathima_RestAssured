package CrudOperationWidBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest 
{
	@Test
	public void getSingleProjectTest()
	{
		//step 1: create pre requisits
		baseURI = "http://localhost:8084/";
				
		//Step 2: actions
		when()
			.get("projects/TY_PROJ_408")
				
		.then()		//Step 3: validate        
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}
}
