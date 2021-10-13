package Demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadDataFromJsonFileJSONObject
{
	/* This method will return json value based on json key
	 * @param jsonKey
	 * @return jsonValue
	 * @throws Throwable           
	*/ 
	
	@Test
	public void getDataFromJson() throws Throwable  
	{
		// Read the data from JSON file
		FileReader reader = new FileReader("./Data/CommonData.json");
		
		// Convert the JSON file into java object
		JSONParser parser = new JSONParser();
		Object object = parser.parse(reader);
		
		// Type cast java object to JSON object
		JSONObject jsonObject = (JSONObject)object;
		
		String Url = jsonObject.get("url").toString();
		String Browser = jsonObject.get("browser").toString();
		String Username = jsonObject.get("username").toString();
		String Password = jsonObject.get("password").toString();
		
		System.out.println(Url);
		System.out.println(Browser);
		System.out.println(Username);
		System.out.println(Password);

	}
}

