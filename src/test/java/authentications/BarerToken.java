package authentications;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BarerToken
{
	@Test
	public void barerToken()
	{
		baseURI="https://api.github.com/";
		
		JSONObject jObj= new JSONObject();
		jObj.put("name", "Zeeshuuuu");
		
		given()
			.auth().oauth2("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")
			.body(jObj)
			.contentType(ContentType.JSON)
			
		.when()
			.post("user/repos")
			
		.then()
			.log().all();
	}
}
