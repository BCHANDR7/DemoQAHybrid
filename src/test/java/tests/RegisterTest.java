package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import action.RegisterAction;
import factory.DriverFactory;
import utils.ExtentManager;

public class RegisterTest {
	
	WebDriver driver;
	ExtentTest test;
	
	@BeforeClass
	public void setup()
	{
		driver=DriverFactory.getDriver();
	}
	
	@Test
	public void RegisterProcess() throws Exception
	{
		test=ExtentManager.getReport().createTest("Student registration").assignAuthor("Balaji");
		RegisterAction ra= new RegisterAction(driver,test);
		ra.registerPage();
		
	}
	
	@AfterClass(enabled = false)
	public void closeDriver()
	{
		DriverFactory.quitDriver();
	}
	
	@AfterSuite
	public void closetheReport()
	{
		ExtentManager.closeReport();
	}

}
