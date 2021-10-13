package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQA 
{
	public static void main(String[]args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//button[text()='Hover me to see']"));
		act.moveToElement(button).perform();
		
		Thread.sleep(2000);
		
		String toolTip = driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).getText();
		
	    driver.findElement(By.xpath("//input[@placeholder='Hover me to see']")).sendKeys(toolTip);
		
	    driver.close();
	}
}
  