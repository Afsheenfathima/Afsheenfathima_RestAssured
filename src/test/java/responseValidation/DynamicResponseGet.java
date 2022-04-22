package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.response.Response;
import projectLibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseGet
{
	@Test
	public void dynamicResponseGet()
	{
		//Pre requisits
		baseURI = "http://localhost:8084/";
		String expData = "Aaira";
		
		//Actions
		Response resp = when()
							.get("projects");
		
		//Validation
		boolean flag = false;
		List<String> pName = resp.jsonPath().get("projectName");
		for (String Name : pName) 
		{
			if(Name.contains(expData))
			{
				flag = true;
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("Data Verified");
		
		resp.then().log().all();	
	}
}
