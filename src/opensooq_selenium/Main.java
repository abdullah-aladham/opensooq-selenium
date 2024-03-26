package opensooq_selenium;



import org.testng.Assert;
import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertFalse;
import  static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;


public class Main {
	
	
	WebDriver driver = new ChromeDriver();
	@BeforeClass(groups="setup")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver.manage().window().maximize();
	}
	@Test(groups="Home")
	public void Home() 
	{
		
		driver.get("https:www.opensooq.com/");
	
	String Expected="السوق المفتوح فلسطين : سيارات : عقارات : بيوت : للبيع : خدمات : وظائف";
	String Actual=driver.getTitle();
	Assert.assertEquals(Actual, Expected);
	//AssertFalse(Actual,Expected);
	
	}
	
 public void TakeScreen() {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(screenshotFile , new File("C:\\Users\\Msys\\eclipse-workspace\\opensooq_selenium\\src\\screenshots\\Home\\Home.png"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}  
 }


	
//	@AfterTest(groups="opensooq")
//	public void Final() 
//	{
//		driver.close();
//	}
	@Test
	public void HomePage_En() {
		driver.get("https:jo.opensooq.com/en");
		TakeScreen();
	}
	@Test(priority=2,groups="Login")
	public void login() {
		driver.findElement(By.xpath("/html/body/div[3]/header[1]/section/div[2]/button[4]")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div[2]/div[1]/div[1]/div/div/input")).sendKeys("123456789");
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div[2]/div[1]/button")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String err=driver.findElement(By.xpath("//span[@class='font-12 redColor block mt-8']")).getText();
		assertTrue(err==null);
		TakeScreen();
//	   
	}
	@AfterTest(groups="close")
	public void closepage() {
		driver.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
