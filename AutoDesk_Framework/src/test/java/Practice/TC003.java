package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC003
{
//	static
//	{
//		System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//	}
	
	public static void main(String []args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("iphone 12 pro max"+Keys.ENTER);
		
		WebElement mobile = driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 12 Pro Max (Silver, 512 GB)')]"));
		mobile.click();
		
		WebElement addToCart = driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]"));
		addToCart.click();
		
		driver.navigate().back();
		
		searchBox.sendKeys("Laptop"+Keys.ENTER);
		WebElement laptop = driver.findElement(By.xpath("//div[contains(text(),'MSI Modern 14 Core i5 10th Gen')]"));
		laptop.click();
		addToCart.click();
		driver.navigate().back();
			
		WebElement cartButton = driver.findElement(By.xpath("//span[contains(text(),'Cart')]"));
		cartButton.click();
		
		WebElement myCart = driver.findElement(By.xpath("My Cart (2)"));
		
		if (mobile.isDisplayed() && laptop.isDisplayed())
		{
			System.out.println("PASSED : Mobile and Laptop Added to the Cart");
		}
		else
		{
			System.out.println("FAILED : Mobile and Lapto Not Added to the Cart");
		}
		
//		if (laptop.isDisplayed())
//		{
//			System.out.println("Laptop Added to the Cart");
//		}
	}
}
