package CrudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectsTest 
{
	@Test
	public void updateProjectTest()
	{
		//Step1: Create the pre requisites (for post request body is pre-requisite)
				JSONObject jObj= new JSONObject();
				jObj.put("createdBy", "Afsheen");
				jObj.put("projectName", "MNO");
				jObj.put("status", "Completed");
				jObj.put("teamSize", 15);
				
				RequestSpecification request = RestAssured.given();
				request.body(jObj);
				request.contentType(ContentType.JSON);
				
				//Step2: Perform actions
				Response response = request.put("http://localhost:8084/projects/TY_PROJ_1202");
				
				//Step3: Validate the response
				response.then().log().all();
				int actStatus = response.getStatusCode();
				Assert.assertEquals(actStatus, 200);	
	}
}
