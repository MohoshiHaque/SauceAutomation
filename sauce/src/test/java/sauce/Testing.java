package sauce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	WebDriver driver;
	
	@BeforeTest
	public void Init() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	
	public void TestTitle() throws InterruptedException {
		
		String ExpectedTitle="Swag Labs";
		String Actualtitle= driver.getTitle();
	    System.out.println(Actualtitle);
	    Assert.assertEquals(Actualtitle, ExpectedTitle,"Kmn");
	}
	
	@Test(priority=2)
	
	public void Testurl() throws InterruptedException {
		
		String Expectedurl="https://www.saucedemo.com/";
		String Actualurl= driver.getCurrentUrl();
	    System.out.println(Actualurl);
	    Assert.assertEquals(Actualurl, Expectedurl,"Kmn");
	}
	
	@Test(priority=3)
	
	public void InputInvalidUserName() throws InterruptedException {
		
		String NameExpectWarning = "Epic sadface: Username and password do not match any user in this service";
		driver.findElement(By.id("user-name")).sendKeys("standard_user1");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String NameActualWarning= driver.findElement(By.className("error-message-container")).getText();
		System.out.println(NameActualWarning);
		Assert.assertEquals(NameActualWarning,NameExpectWarning,"Pass");
		
		//Clear Name and password
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("password")).clear();
		
	}
	
	
	@Test(priority=4)
	public void InputInvalidPassword() throws InterruptedException {
		

		String PassExpectWarning = "Epic sadface: Username and password do not match any user in this service";
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("secret_sauce1");
		driver.findElement(By.id("login-button")).click();
		
		String PassActualWarning= driver.findElement(By.className("error-message-container")).getText();
		System.out.println(PassActualWarning);
		Assert.assertEquals(PassActualWarning,PassExpectWarning,"Pass");
		
		
	}
	
	
	
}
