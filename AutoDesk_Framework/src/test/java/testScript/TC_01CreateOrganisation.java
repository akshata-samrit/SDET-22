package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

/**
 * 
 * @author Akshata
 *
 */

public class TC_01CreateOrganisation 
{
	
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = new ChromeDriver();
		
		// Here we create a object of File Utility, Java Utility, Web Driver Utility, Excel Utility
		FileUtility fileUtil = new FileUtility();
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		
		driver.manage().window().maximize();
		
		// Implicit wait
		wdUtil.waitUntilPageLoad(driver);
		
		// Taking Common Data from JSON File
		String url = fileUtil.getDataFromJSON("url");
		driver.get(url);
		String username = fileUtil.getDataFromJSON("username");
		String password = fileUtil.getDataFromJSON("password");
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		

		String orgName = eUtil.getExcelData("Sheet1", 1, 1);
		System.out.println(orgName);
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		
		String website = eUtil.getExcelData("Sheet1", 1, 2);
		driver.findElement(By.name("website")).sendKeys(website);
		
		String tickerSymbol = eUtil.getExcelData("Sheet1", 1, 3);
		driver.findElement(By.id("tickersymbol")).sendKeys(tickerSymbol);
		
//		driver.findElement(By.xpath("//img[@title='Select']")).click();
//		driver.findElement(By.name("search_text")).sendKeys("1234567890");
		
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		wdUtil.SelectOption(industryDropDown, "Banking");
		
		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
		wdUtil.SelectOption(typeDropDown, "Customer");
		
		driver.findElement(By.name("emailoptout")).click();
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement groupDropDown = driver.findElement(By.name("assigned_group_id"));
		wdUtil.SelectOption(groupDropDown, "Support Group");
		
		
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		
		String email = eUtil.getExcelData("Sheet1", 1, 9);
		driver.findElement(By.id("email1")).sendKeys(email);
		
		WebElement ratingDropDown = driver.findElement(By.name("rating"));
		wdUtil.SelectOption(ratingDropDown, "Active");
		
		driver.findElement(By.name("notify_owner")).click();
		
		String billingAddress = eUtil.getExcelData("Sheet1", 1, 12);
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(billingAddress);
		
		String billingPoBox = eUtil.getExcelData("Sheet1", 1, 13);
		driver.findElement(By.name("bill_pobox")).sendKeys(billingPoBox);
		
		String billingCity = eUtil.getExcelData("Sheet1", 1, 14);
		driver.findElement(By.name("bill_city")).sendKeys(billingCity);
		
		String billingState = eUtil.getExcelData("Sheet1", 1, 15);
		driver.findElement(By.name("bill_state")).sendKeys(billingState);
		
		driver.findElement(By.name("bill_code")).sendKeys("560076");
		
		String billingCountry = eUtil.getExcelData("Sheet1", 1, 17);
		driver.findElement(By.name("bill_country")).sendKeys(billingCountry);
		
		driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();	
		
		driver.findElement(By.name("button")).click();
		Thread.sleep(5000);
		
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdUtil.mouseHover(driver, signout);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		System.out.println("Organization Created");
		
		driver.close();


	}
	
}
