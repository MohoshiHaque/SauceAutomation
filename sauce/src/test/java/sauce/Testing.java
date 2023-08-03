package sauce;

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

	    Thread.sleep(6000);
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
	
	

}
