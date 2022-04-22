package CrudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest
{
	@Test
	public void createProjectTest()
	{
		//Step1: Create the pre requisites (for post request body is pre-requisite)
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Afsheen");
		jObj.put("projectName", "MNO");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		RequestSpecification request = RestAssured.given();
		request.body(jObj);
		request.contentType(ContentType.JSON);
		
		//Step2: Perform actions
		Response response = request.post("http://localhost:8084/addProject");
		
		//Step3: Validate the response
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
	}
}
