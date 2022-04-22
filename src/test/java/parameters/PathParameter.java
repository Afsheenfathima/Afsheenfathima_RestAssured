package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter 
{
	@Test
	public void getSingleProject()
	{
		//Pre requisites
		baseURI="http://localhost:8084/";
		
		given()
			.pathParam("pid", "TY_PROJ_404")
		
		//actions
		.when()
			.get("projects/{pid}")
			
		//validation
		.then()
			.log().all();
		
	}
}
