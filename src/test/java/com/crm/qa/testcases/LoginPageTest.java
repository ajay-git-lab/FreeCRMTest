package com.crm.qa.testcases;

//import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		//give LoginPage class object to loginPage reference variable
		loginPage = new LoginPage();
	}
	
	@Test (priority=1)
	public void loginPageTiltleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
