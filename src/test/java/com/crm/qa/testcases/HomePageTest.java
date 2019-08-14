package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	//test cases should be separated -- independent from each other
	//before each test case launch the browser and login
	//@test -- execute the test case
	//after each test case close the browser
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePagetitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		String userName = homePage.verifyCorrectUserName();
		Assert.assertEquals(userName, "  User: Navneet Kaur Dusaj","INVALID USERNAME");
	}
	@Test(priority = 3)
	public void verfigyContactsListTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
