package commonLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic method related to database
 * @author ZEESHAN
 *
 */
public class DataBaseLibrary
{
	Driver driver;
	Connection con;
	
	/**
	 * This method will establish the connection with the database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(ConstantLibrary.dbURL,ConstantLibrary.dbUsername,ConstantLibrary.dbPassword);
	}
	
	
	/**
	 * This method will close the database
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	/**
	 * this method will check the database for expected data and return
	 * @param query
	 * @param expData
	 * @param column
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, String expData, int column) throws Throwable
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String Data = result.getString(column).toString();
			if(Data.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(expData +"data verified");
			return expData;
		}
		else
		{
			System.out.println("data not matched");
			return "";
		}
	}
}
