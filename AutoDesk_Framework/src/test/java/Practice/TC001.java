package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001
{
//	static
//	{
//		System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//	}
//	
	public static void main(String []args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
	//	driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		driver.findElement(By.name("q")).sendKeys("samsung mobiles"+Keys.ENTER);
		
		List<WebElement> mobile = driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG Galaxy F22')]"));
        int count = mobile.size();
        System.out.println(count);
        
        for(int i=0 ; i<count ; i++)
        {
        	String mobileName = mobile.get(i).getText();
            System.out.println(mobileName);	
        }
        driver.close();
	}
}
