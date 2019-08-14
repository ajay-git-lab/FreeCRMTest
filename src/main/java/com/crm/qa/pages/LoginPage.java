package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR
	@FindBy(name="username") //annotation
	WebElement username;
	
	@FindBy(name="password") //annotation
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[contains(@href,'https://classic.crmpro.com/index.html')]//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initialize Page object
	public LoginPage() { //Constructor
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		System.out.println("UN Enetered");
		password.sendKeys(pwd);
		System.out.println("PW Enetered");
		Thread.sleep(5000);
		loginBtn.click();
		System.out.println("Clicked Login");
		return new HomePage();
			}

}
