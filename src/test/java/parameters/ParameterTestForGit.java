package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ParameterTestForGit 
{
	@Test
	public void parameterTest()
	{
		baseURI="https://api.github.com";
		
		given()
			.pathParam("username", "Afsheenfathima")
			.queryParam("per_page", 30)
			.queryParam("page", 1)
			
		.when()
			.get("/users/{username}/repos")
			
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}
