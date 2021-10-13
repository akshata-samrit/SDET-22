package testScript;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_02CreateContactsHardCode 
{
	public static void main(String[] args) throws InterruptedException, Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		WebElement firstNameDown = driver.findElement(By.name("salutationtype"));
		Select s1 = new Select(firstNameDown);
		s1.selectByValue("Ms.");
		
		driver.findElement(By.name("firstname")).sendKeys("Akshata");
		driver.findElement(By.name("lastname")).sendKeys("Samrit");
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		//driver.findElement(By.xpath("//a[text()='Citi Bank']")).click();
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		//int count =windows.size();
		//System.out.println(count);
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext())
		{
			String p = itr.next();
			String c = itr.next();
		
			if (!parent.equals(c))
			{
				driver.switchTo().window(c);
				//System.out.println(driver.switchTo().window(w).getTitle());
				driver.findElement(By.linkText("Citi Bank")).click();
//				Thread.sleep(5000);
//				driver.close();
			}

		}
		driver.switchTo().window(parent);
		
		WebElement leadSourceDropDown = driver.findElement(By.name("leadsource"));
		Select s2 = new Select(leadSourceDropDown);
		s2.selectByValue("Employee");
		
		driver.findElement(By.name("title")).sendKeys("TE");
		driver.findElement(By.name("department")).sendKeys("Insurance");
		driver.findElement(By.name("email")).sendKeys("abcxyz@gmail.com");
		driver.findElement(By.name("assistantphone")).sendKeys("23456789");
		driver.findElement(By.name("emailoptout")).click();
		driver.findElement(By.name("reference")).click();
		driver.findElement(By.name("notify_owner")).click();
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElement(By.name("mobile")).sendKeys("4557890");
		
//		driver.findElement(By.id("jscal_trigger_birthday")).click();
//		driver.findElement(By.xpath("//td[text()='September, 1994']"))
		
		driver.findElement(By.id("jscal_field_birthday")).sendKeys("1994-09-24");
		driver.findElement(By.name("donotcall")).click();
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement assignedToDropDown = driver.findElement(By.name("assigned_group_id"));
		Select s3 = new Select(assignedToDropDown);
		s3.selectByVisibleText("Support Group");
		
		driver.findElement(By.name("portal")).click();
		
//		WebElement chooseFileButton = driver.findElement(By.name("imagename"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0]", chooseFileButton);
//		chooseFileButton.sendKeys("C:\\Users\\Akshata\\Desktop\\VtigerTestCasesMyData.doc");
		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);

		
//		try {
//			w.click();
//			Runtime run = Runtime.getRuntime();
//			run.exec("C:\\Users\\Akshata\\Desktop\\Upload.exe");
//
//		}catch(Exception e) {
//			System.out.println("****************"+e.getMessage());
//			throw e;
//		}
		

	
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		System.out.println("Contact Created");
		
		driver.close();

		

		
	}
}
