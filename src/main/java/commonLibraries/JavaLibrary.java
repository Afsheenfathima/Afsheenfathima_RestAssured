package commonLibraries;

import java.util.Random;

/**
 * This class contains generic method related to java
 * @author ZEESHAN
 *
 */
public class JavaLibrary
{
	/**
	 * This method will generate random number for every executions
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		return ran.nextInt(1000);
	}
}
