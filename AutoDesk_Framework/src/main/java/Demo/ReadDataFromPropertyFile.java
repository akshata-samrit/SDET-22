package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile 
{
	@Test
	public void readDataFromPropertyFile() throws IOException
	{
		/* Read the data from properties file */
		
		// Step 1 : get the java representation object of the physical file */
		FileInputStream fis=new FileInputStream("./Data/CommonData.properties");
				
		/* Step 2 : Create an object of the properties class & load all the
		            keys : values pair */
		Properties pobj=new Properties();
		pobj.load(fis);
		
		// Step 3 : Read the value using getproperty ("key")
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

	}
}
