package CrudOperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest 
{
	@Test
	public void deleteProject()
	{

		//Step 1: create Pre requisites
		
		//Step 2: Perform the action
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1202");
				
		//Step 3: provide validation
		resp.then().log().all();
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, 204);
	}
}
