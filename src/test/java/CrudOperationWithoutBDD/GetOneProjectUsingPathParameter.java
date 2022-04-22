package CrudOperationWithoutBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetOneProjectUsingPathParameter
{
	@Test
	public void getRepoTest()
	{
		given()
			.auth().basic("rmgyantra", "rmgy@999")
//			.pathParam("ownerName", "Afsheenfathima")
//			.pathParam("repoName", "Zees")
			.queryParam("q", "Zees")
			.queryParam("sort", "updated")
		.when()
//			.get("https://api.github.com/user/repos/{ownerName}/{repoName}")
			.get("https://api.github.com/search/repositories")
		.then()
			.log().all();
	}
}
