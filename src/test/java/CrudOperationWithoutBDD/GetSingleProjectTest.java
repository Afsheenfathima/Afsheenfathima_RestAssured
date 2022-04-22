package CrudOperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest 
{
	@Test
	public void getsingleProjectTest()
	{
		//Step 1: create Pre requisites
		
		//Step 2: Perform the action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1202");
				
		//Step 3: provide validation
		resp.then().log().all();
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(200, actStatus);
	}
}
