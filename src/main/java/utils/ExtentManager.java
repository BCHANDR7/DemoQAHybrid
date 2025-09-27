package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;
	
	
	public static ExtentReports getReport()
	{
		if(extent==null)
		{
			ExtentSparkReporter spark=new ExtentSparkReporter(System.getProperty("user.dir")+"//report//ExtentReport.html");
			extent= new ExtentReports();
			extent.attachReporter(spark);
			
		}
		return extent;
	}
	
	
	public static void closeReport()
	{
		extent.flush();
	}
}
