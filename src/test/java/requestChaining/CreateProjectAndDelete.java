package requestChaining;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectAndDelete
{
	@Test
	public void createAndDeleteProject()
	{
		//Create a project using POJO

		JavaLibrary jLib= new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary("Aaira", "CEO"+jLib.getRandomNumber(), "On Going", 1);
		baseURI = "http://localhost:8084/";

		Response resp = given()
							.body(pLib)
							.contentType(ContentType.JSON)

						.when()
							.post("addProject");

		//Capture ProjectId
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();

		//Create a get request and pass proId as path parameter
		given()
			.pathParam("pid", proId)

		.when()
			.delete("projects/{pid}")

		.then()
			.assertThat().statusCode(204)
			.log().all();	
	}
}
