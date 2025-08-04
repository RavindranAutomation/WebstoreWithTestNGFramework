package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.HeaderPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PasswordRecoveryPage;
import com.orangehrm.utilities.ExtentManager;

public class ForgetPasswordTest extends BaseClass{
	
	
	private LoginPage loginPage;
	private HeaderPage headerPage;
	private PasswordRecoveryPage recoveryPage;
	
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		headerPage  = new HeaderPage(getDriver());
		recoveryPage = new PasswordRecoveryPage(getDriver());
	}
	
	@Test
	public void TC_007_VerifyForgotPassword() {
		ExtentManager.logStep("Navigating to login page");
		ExtentManager.logStep("Clicking on Login header");
		headerPage.clickOnLoginHeader();
		ExtentManager.logStep("Clicking on Forgot password");
		loginPage.clickOnForgotPassword();
		ExtentManager.logStep("Entering recovery email in the email email field");
		recoveryPage.enterEmailInRecoveryEmailField();
		ExtentManager.logStep("Clicking on recovery button");
		recoveryPage.clickOnRecoveryBtn();
		ExtentManager.logStep("Validating recovery sent message - " + recoveryPage.getRecoveryInstructionMessage());
		Assert.assertEquals("Email with instructions has been sent to you.", recoveryPage.getRecoveryInstructionMessage());
		

	}

}
