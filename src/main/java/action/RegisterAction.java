package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import config.Constants;
import pages.RegisterPage;
import utils.ExcelUtil;
import utils.ExtentManager;

public class RegisterAction {
	WebDriver driver;
	ExtentTest test;
	List<HashMap<String, String>> dataMap;
	
	

	public RegisterAction(WebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test=test;
	}



	public void registerPage() throws Exception {
		RegisterPage rp=new RegisterPage(driver,test);
		rp.openURL(Constants.URL);
		dataMap=ExcelUtil.data(Constants.TESTDATA_PATH, Constants.TESTDATA_SHEET);
		System.out.println("DataMap Size "+dataMap.size());
		System.out.println(dataMap);
		
		for(int i=0;i<dataMap.size();i++)
		{
		rp.enterFirstName(dataMap.get(i).get("FirstName"));
		rp.enterSecondName(dataMap.get(i).get("SecondName"));
		rp.enterEmail(dataMap.get(i).get("Email"));
		rp.selectGender(dataMap.get(i).get("Gender"));
		rp.enterMobile(dataMap.get(i).get("Mobile(10 Digits)"));
		rp.enterDOB(dataMap.get(i).get("DOB"));
		rp.enterSubject(dataMap.get(i).get("Subjects"));
		rp.enterHobbies(dataMap.get(i).get("Hobbies"));
		rp.selectPic(dataMap.get(i).get("Picture"));
		rp.enterAddress(dataMap.get(i).get("Current Address"));
		rp.selectState(dataMap.get(i).get("State"));
		rp.selectCity(dataMap.get(i).get("City"));
		rp.clickSubmit();
		
		}
		
		
	}

}
