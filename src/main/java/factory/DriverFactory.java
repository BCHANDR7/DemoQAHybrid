package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class DriverFactory {

	private static WebDriver driver;
	
	
	public static WebDriver getDriver()
	{
		if(driver==null)
		{
			System.setProperty("Webdriver.chrome.driver", "D:\\Automation library\\Browser\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		return driver;
	}
	
	
	public static void quitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
}
