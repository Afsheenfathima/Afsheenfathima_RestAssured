package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDiffData 
{
	@Test(dataProvider = "getData")
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{
		//Pre requisites
		JavaLibrary jLib = new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+jLib.getRandomNumber(), status, teamSize);
		
		baseURI = "http://localhost:8084/";
		
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
			
		.when()						//action
			.post("addProject")
			
		.then()						//validation
			.log().all();
	}
	
	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object[][] data = new Object[2][4];
		
		data[0][0]="Afsheen";
		data[0][1]="TCS";
		data[0][2]="Created";
		data[0][3]=12;
		
		data[1][0]="Aaira";
		data[1][1]="Google";
		data[1][2]="On Going";
		data[1][3]=19;
			
		return data;
	}
}
