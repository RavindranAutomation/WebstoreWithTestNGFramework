package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.HeaderPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.DataProviders;
import com.orangehrm.utilities.ExtentManager;

public class LoginTest extends BaseClass{
	
	private LoginPage loginPage;

	private HeaderPage headerPage;
	
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		headerPage  = new HeaderPage(getDriver());
	}
	@Test(dataProvider="validLoginData", groups = { "Smoke","Sanity", "Master" },dataProviderClass = DataProviders.class,priority = 1)
	public void TC_004_LoginWithValidCredentials(String username,String password) {
	
		ExtentManager.logStep("Navigating to Login Page entering username and password");
	
		logger.debug("Clicking on login header");
		headerPage.clickOnLoginHeader();

		loginPage.login(username,password);
		ExtentManager.logStep("Validation Successful");
	
		headerPage.clickOnLogoutHeader();
	
	
	}
	
	@Test(dataProvider="inValidLoginData", dataProviderClass = DataProviders.class,priority = 2,groups = { "Sanity", "Master" })
	public void TC_005_LoginWithInvalidCredentials(String username,String password) {
		String testName="TC_005_LoginWithInvalidCredentials";
		ExtentManager.logStep("Navigating to Login Page entering username and password");
		logger.info(testName+"Test started");

		headerPage.clickOnLoginHeader();
		logger.debug("Invoking login resuable method to login");
		loginPage.login(username,password);
		ExtentManager.logStep("Validation Unsuccessfull");
		logger.info("Validating invalid login message");
		Assert.assertEquals(loginPage.isInvalidLoginMessageiDispalyed(), true);
		ExtentManager.logStep("Login was unsuccessfull message displayed");
		logger.info("************ Ending Test -  TC_005_LoginWithInvalidCredentials ************ ");

	}
	@Test(priority = 3)
	public void TC_006_LoginWithEmptyFields() {
		logger.info("************ Starting Test - TC_006_LoginWithEmptyFields ************ ");
		ExtentManager.logStep("Navigating to Login Page entering username and password");
		logger.debug("Clicking on login header");
		headerPage.clickOnLoginHeader();
		logger.debug("Invoking login resuable method to login");
		loginPage.login("","");
		ExtentManager.logStep("Validation Unsuccessfull");
		logger.info("Validating invalid login message");
		Assert.assertEquals(loginPage.isInvalidLoginMessageiDispalyed(), true);
		ExtentManager.logStep("Login was unsuccessfull message displayed");
		logger.info("************ Ending Test -  TC_006_LoginWithEmptyFields ************ ");
	}

}
