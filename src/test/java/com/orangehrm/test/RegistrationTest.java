package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.HeaderPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RegistrationPage;
import com.orangehrm.utilities.ExtentManager;

public class RegistrationTest extends BaseClass {

	private LoginPage loginPage;
	private HeaderPage headerPage;
	private RegistrationPage registerPage;
	private HomePage homePage;

	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		headerPage = new HeaderPage(getDriver());
		registerPage = new RegistrationPage(getDriver());
		homePage = new HomePage(getDriver());

	}

	@Test(priority = 1)
	public void TC_001_RegisterWithValidDetails() {
		try {
			ExtentManager.logStep("************ Starting registration test ************");
			ExtentManager.logStep("Clicking on register header");
			headerPage.clickOnRegisterHeader();
			ExtentManager.logStep("Selecting gender");
			registerPage.selectMaleGender();
			ExtentManager.logStep("Setting up Firstname");
			registerPage.setFirstName(randomString().toUpperCase());
			ExtentManager.logStep("Setting up Lastname");
			registerPage.setLastName(randomString().toUpperCase());
			ExtentManager.logStep("Setting up Email");
			registerPage.setEmail(randomString() + "@yopmail.com");
			ExtentManager.logStep("Setting up password");
			registerPage.setPassword();
			ExtentManager.logStep("Setting up Confirm password");
			registerPage.setConfirmPassword();
			ExtentManager.logStep("Clicking on Register button");
			registerPage.clickOnRegisterBtn();
			ExtentManager.logStep("Validating registration success message");
			Assert.assertEquals(homePage.getRegisterSuccessMessage(), "Your registration completed");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentManager.logStep("Registration is failed - " + e.getMessage());
		}

	}

	@Test(priority = 2)
	public void TC_002_registerWithExistingEmail() {
		try {
			ExtentManager.logStep("Clicking on register header");
			headerPage.clickOnRegisterHeader();
			ExtentManager.logStep("Selecting gender");
			registerPage.selectMaleGender();
			ExtentManager.logStep("Setting up Firstname");
			registerPage.setFirstName(randomString().toUpperCase());
			ExtentManager.logStep("Setting up Lastname");
			registerPage.setLastName(randomString().toUpperCase());
			ExtentManager.logStep("Setting up Email");
			registerPage.setEmail(prop.getProperty("username"));
			ExtentManager.logStep("Setting up password");
			registerPage.setPassword();
			ExtentManager.logStep("Setting up Confirm password");
			registerPage.setConfirmPassword();
			ExtentManager.logStep("Clicking on Register button");
			registerPage.clickOnRegisterBtn();
			ExtentManager.logStep("Validating existing email error message");
			Assert.assertEquals(registerPage.getEmailalreadyexistsmessage(), "The specified email already exists");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentManager.logStep("Registration is failed - " + e.getMessage());
		}

	}

	@Test(priority = 3)
	public void TC_003_registerWithInvalidEmailFormat() {
		try {
			ExtentManager.logStep("Clicking on register header");
			headerPage.clickOnRegisterHeader();
			ExtentManager.logStep("Selecting gender");
			registerPage.selectMaleGender();
			ExtentManager.logStep("Setting up Firstname");
			registerPage.setFirstName(randomString().toUpperCase());
			ExtentManager.logStep("Setting up Lastname");
			registerPage.setLastName(randomString().toUpperCase());
			ExtentManager.logStep("Setting up Email");
			registerPage.setEmail(prop.getProperty("invalidEmail"));
			ExtentManager.logStep("Setting up password");
			registerPage.setPassword();
			ExtentManager.logStep("Setting up Confirm password");
			registerPage.setConfirmPassword();
			ExtentManager.logStep("Clicking on Register button");
			registerPage.clickOnRegisterBtn();
			ExtentManager.logStep("Validating invalid email error message");
			Assert.assertEquals(registerPage.getInvalidEmailMessage(), "Wrong email");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Testcase is failed" + e.getMessage());

		}

	}

}
