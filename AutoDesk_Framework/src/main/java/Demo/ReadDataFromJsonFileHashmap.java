package Demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJsonFileHashmap
{
	@Test
	public void readDataFromJSON() throws Throwable
	{
		// Read the data from JSON file
		FileReader file = new FileReader("./Data/CommonData.json");
		
		// Convert the JSON file into java object
		JSONParser jsonobj = new JSONParser();
		Object jobj = jsonobj.parse(file);
		
		// Type cast java object to Hashmap
		HashMap map = (HashMap)jobj;
		
		String USERNAME = map.get("username").toString();
		System.out.println(USERNAME);
		
		String PASSWORD = map.get("password").toString();
		System.out.println(PASSWORD);
		
		String URL = map.get("url").toString();
		System.out.println(URL);
		
		String BROWSER = map.get("browser").toString();
		System.out.println(BROWSER);
				
		
	}
}
