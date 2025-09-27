package base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import factory.DriverFactory;
import utils.ExtentManager;

public class BasePage {
	
	protected WebDriver driver;
	protected ExtentTest test;
    
	public BasePage(WebDriver driver, ExtentTest test) {
	this.driver = driver;              // fix assignment
	this.test = test;    // initialize test instance
	PageFactory.initElements(driver, this);
	}
	
	public void urlOpen(String url) throws Exception
	{
		try {
			this.driver.get(url);
			test.pass("URL Opened",MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		} catch (Exception e) {
			test.fail("URL not Opened",MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		}
	}
	
	public void enter(WebElement element, String value) throws Exception
	{
		try {
			element.sendKeys(value);
			test.pass(value+" is entered", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		} catch (Exception e) {
			test.fail(value+"is not entered", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		}
	}
	
	public void click(WebElement element) throws Exception
	{
		try {
			element.click();
			test.pass("Button is clicked ",MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		} catch (Exception e) {
			test.fail("Button is not clicked ",MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		}
	}
	
	public void selectBy(WebElement element, String value) throws Exception
	{
		try {
			Select se=new Select(element);
			se.selectByVisibleText(value);
			test.pass(value+" is clicked", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		} catch (Exception e) {
			test.fail(value+" is not clicked", MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		}
	}
	
	public void chooseFile(String path) throws Exception
	{
		try {
			StringSelection selection= new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			
			Robot robo=new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_C);
			Thread.sleep(300);
			robo.keyRelease(KeyEvent.VK_C);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			test.pass("Image is uploaded",MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		} catch (Exception e) {
			test.fail("Image is not uploaded",MediaEntityBuilder.createScreenCaptureFromPath(capture()).build());
		}
		
	}
	
	
	public String capture() throws Exception
	{
		File srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destPath= new File(System.getProperty("user.dir")+"\\Report\\Images\\Screenshots"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(srcPath, destPath);
		return destPath.getAbsolutePath();
	}

}
