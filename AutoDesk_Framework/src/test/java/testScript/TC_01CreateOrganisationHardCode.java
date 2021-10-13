package testScript;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_01CreateOrganisationHardCode 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Citi Bank");
		driver.findElement(By.name("website")).sendKeys("www.citibank.com");
		driver.findElement(By.id("tickersymbol")).sendKeys("CB");
		
//		driver.findElement(By.xpath("//img[@title='Select']")).click();
//		driver.findElement(By.name("search_text")).sendKeys("1234567890");
		
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s1 = new Select(industryDropDown);
		s1.selectByValue("Banking");
		
		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
		Select s2 = new Select(typeDropDown);
		s2.selectByValue("Customer");
		
		driver.findElement(By.name("emailoptout")).click();
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement groupDropDown = driver.findElement(By.name("assigned_group_id"));
		Select s3 = new Select(groupDropDown);
		s3.selectByVisibleText("Support Group");
		
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		driver.findElement(By.id("email1")).sendKeys("abc123@gmail.com");
		
		WebElement ratingDropDown = driver.findElement(By.name("rating"));
		Select s4 = new Select(ratingDropDown);
		s4.selectByValue("Active");
		
		driver.findElement(By.name("notify_owner")).click();
		
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("JP Nagar 7th Phase");
		driver.findElement(By.name("bill_pobox")).sendKeys("JP Nagar");
		driver.findElement(By.name("bill_city")).sendKeys("Bangalore");
		driver.findElement(By.name("bill_state")).sendKeys("Karnataka");
		driver.findElement(By.name("bill_code")).sendKeys("560076");
		driver.findElement(By.name("bill_country")).sendKeys("India");
		
		driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();	
		
		driver.findElement(By.name("button")).click();
		Thread.sleep(5000);
		
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		System.out.println("Organization Created");
		
		driver.close();
	}

	
}
