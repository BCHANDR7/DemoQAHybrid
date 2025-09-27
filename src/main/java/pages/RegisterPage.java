package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import base.BasePage;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver, ExtentTest test) {
		super(driver,test);
		
	}
	
	@FindBy(css = "input[id='firstName']")
	private WebElement firstNameInput;
	
	@FindBy(css = "input[id='lastName']")
	private WebElement lastNameInput;
	
	@FindBy(css = "input[id='userEmail']")
	private WebElement emailInput;
	
	@FindBy(css="input[id='gender-radio-1']")
	private WebElement gender1;
	
	@FindBy(css = "input[id='gender-radio-2']")
	private WebElement gender2;
	
	@FindBy(css = "input[id='userNumber']")
	private WebElement mobile;
	
	@FindBy(css = "input[id='userNumber']")
	private WebElement dobInput;
	
	@FindBy(css = "input[id='subjectsInput']")
	private WebElement subjectInput;
	
	@FindBy(css = "input[id='hobbies-checkbox-1']")
	private WebElement hobbyInput1;
	
	@FindBy(css = "input[id='hobbies-checkbox-2']")
	private WebElement hobbyInput2;
	
	@FindBy(css = "input[id='uploadPicture']")
	private WebElement uploadpic;
	
	@FindBy(css = "textarea[id='currentAddress']")
	private WebElement address;
	
	@FindBy(css = "select[id='stateSelect']")
	private WebElement state;
	
	@FindBy(css = "select[id='citySelect']")
	private WebElement city;
	
	@FindBy(css = "button[id='submit']")
	private WebElement submit;
	
	
	public void openURL(String url) throws Exception {
		urlOpen(url);
		
	}
	
	public void enterFirstName(String fname) throws Exception
	{
		enter(firstNameInput, fname);
	}

	public void enterSecondName(String lname) throws Exception {
	enter(lastNameInput, lname);
		
	}

	public void enterEmail(String email) throws Exception {
		enter(emailInput, email);
		
	}

	public void selectGender(String gen) throws Exception {
		if(gen.equals("Male"))
		{
			click(gender1);
		}
		else
		{
			click(gender2);
		}
		
	}

	public void enterMobile(String mob) throws Exception {
		enter(mobile, mob);
		
	}

	public void enterDOB(String dob) throws Exception {
		enter(dobInput, dob);
		
	}

	public void enterSubject(String sub) throws Exception {
		enter(subjectInput, sub);
		
	}

	public void enterHobbies(String hobby) throws Exception {
		if(hobby.equals("Sports"))
		{
		click(hobbyInput1);
		}
		else {
			click(hobbyInput2);
		}
		
	}

	public void selectPic(String picture) throws Exception {
//		click(uploadpic);
//		Thread.sleep(3000);
//		chooseFile(picture);
		enter(uploadpic, picture);
		
	}

	public void enterAddress(String currentAdd) throws Exception {
		enter(address, currentAdd);
		
	}

	public void selectState(String stateSelect) throws Exception {
		selectBy(state, stateSelect);
		
	}

	public void selectCity(String citySelect) throws Exception {
		selectBy(city, citySelect);
		
	}

	public void clickSubmit() throws Exception {
		click(submit);
		
	}


}
