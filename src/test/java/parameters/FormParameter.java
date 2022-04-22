package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParameter 
{
	@Test
	public void formParameter()
	{
		//Pre requisites
		baseURI="http://localhost:8084/";
		
		given()
			.formParam("createdBy", "Afsheen")
			.formParam("projectName", "Aairuuu")
			.formParam("status", "Completed")
			.formParam("teamSize", 23)
			
		.when()
			.post("addProject")
			
		.then()
			.log().all();
	}
}
