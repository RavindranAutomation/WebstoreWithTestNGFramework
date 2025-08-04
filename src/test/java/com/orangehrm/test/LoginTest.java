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
	@Test(dataProvider="validLoginData", dataProviderClass = DataProviders.class,priority = 1)
	public void TC_004_LoginWithValidCredentials(String username,String password) {
		ExtentManager.logStep("Navigating to Login Page entering username and password");
		headerPage.clickOnLoginHeader();
		loginPage.login(username,password);
		ExtentManager.logStep("Validation Successful");
		headerPage.clickOnLogoutHeader();
		ExtentManager.logStep("Logged out Successfully!");

	}
	
	@Test(dataProvider="inValidLoginData", dataProviderClass = DataProviders.class,priority = 2)
	public void TC_005_LoginWithInvalidCredentials(String username,String password) {
		ExtentManager.logStep("Navigating to Login Page entering username and password");
		headerPage.clickOnLoginHeader();
		loginPage.login(username,password);
		ExtentManager.logStep("Validation Unsuccessfull");
		Assert.assertEquals(loginPage.isInvalidLoginMessageiDispalyed(), true);
		ExtentManager.logStep("Login was unsuccessfull message displayed");


	}
	@Test(priority = 3)
	public void TC_006_LoginWithEmptyFields() {
		ExtentManager.logStep("Navigating to Login Page entering username and password");
		headerPage.clickOnLoginHeader();
		loginPage.login("","");
		ExtentManager.logStep("Validation Unsuccessfull");
		Assert.assertEquals(loginPage.isInvalidLoginMessageiDispalyed(), true);
		ExtentManager.logStep("Login was unsuccessfull message displayed");

	}

}
