package differentWaysToPOST;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO 
{
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary("Afsheen", "XYZ "+jLib.getRandomNumber(), "On Going", 2);
		
		baseURI="http://localhost:8084/";
		
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
			
		.when()
			.post("addProject")
			
		.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
