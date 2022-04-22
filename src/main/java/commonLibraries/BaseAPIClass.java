package commonLibraries;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass
{
	
	public DataBaseLibrary dLib = new DataBaseLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish database connection
		dLib.connectToDB();
		System.out.println("<------------db connection is established------------>");
		
		//set base Uri and port
	    baseURI = "http://localhost";
	    port = 8084; 
	}
	
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
