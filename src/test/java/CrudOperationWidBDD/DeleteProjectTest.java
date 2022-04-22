package CrudOperationWidBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest
{
	@Test
	public void deleteProjectTest()
	{
		//step 1: create pre requisits
		baseURI = "http://localhost:8084/";
		
		//Step 2: actions
		when()
			.delete("projects/TY_PROJ_1205")
		
		.then()		//Step 3: validate        
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(204)
			.log().all();
	}
}
