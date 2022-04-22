package rmgyantraTestsWithFrameWork;

import org.testng.annotations.Test;

import commonLibraries.BaseAPIClass;
import commonLibraries.EndPointLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectLibrary.ProjectLibrary;

public class CreateProjectAndVerifyInDataBase extends BaseAPIClass
{
	@Test
	public void createProjectVerifyInDb() throws Throwable
	{
		//Step 1: create Pre requisites
		ProjectLibrary pLib = new ProjectLibrary("Afsheen", "affu "+jLib.getRandomNumber(), "Completed", 1);
		
		 Response resp = given()
							.body(pLib)
							.contentType(ContentType.JSON)
						
						.when()
							.post(EndPointLibrary.CreateProject);
		 
		 //Step 2: Capture the project ID
		 String expData = rLib.getJsonPath(resp, "projectId");
		 System.out.println(expData);
		 
		 //Step 3: Verify the project in API response
		 given()
		 	.pathParam("pid", expData)
		 	
		 .when()
		 	.get(EndPointLibrary.GetAllprojects+"/{pid}")
		 	
		 .then()
		 	.log().all();
		 
		 System.out.println("Data successfully verified in API response");
		 
		 //Step 4: Verify the project in database
		 String query = "select * from project";
		 String data = dLib.executeQueryAndGetData(query, expData, 1);
		 System.out.println(data);
		 System.out.println("data verified successfully in database");
	}
}
