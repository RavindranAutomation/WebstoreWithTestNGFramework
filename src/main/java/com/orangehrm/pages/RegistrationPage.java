package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class RegistrationPage {
	private ActionDriver actionDriver;

	private static final By maleRadioBtn = By.xpath("//input[@id='gender-male']");
	private static final By femaleRadioBtn = By.xpath("//input[@id='gender-female']");
	private static final By firstNameField = By.xpath("//input[@id='FirstName']");
	private static final By lastNameField = By.xpath("//input[@id='LastName']");
	private static final By emailField = By.xpath("//input[@id='Email']");
	private static final By passwordField = By.xpath("//input[@id='Password']");
	private static final By confirmPasswordField = By.xpath("//input[@id='ConfirmPassword']");
	private static final By registerBtn = By.xpath("//input[@id='register-button']");
	private static final By emailALreadyExistsMessage=By.xpath("//div[@class='validation-summary-errors']/ul/li[contains(text(),'already exists')]");
	private static final By invalidEmailMessage=By.xpath("//input[@id='Email']/following-sibling::span[2]/span[contains(text(),'Wrong')]");
	
	public RegistrationPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	public void selectMaleGender() {

		actionDriver.clickUsingJS(maleRadioBtn);

	}

	public void setFirstName(String firstName) {
		actionDriver.enterText(firstNameField, firstName);

	}

	public void setLastName(String lastName) {
		actionDriver.enterText(lastNameField, lastName);

	}

	public void setEmail(String email) {

		actionDriver.enterText(emailField, email);
	}

	public void setPassword() {
		actionDriver.enterText(passwordField, "Test@12345");
	}

	public void setConfirmPassword() {
		actionDriver.enterText(confirmPasswordField, "Test@12345");

	}

	public void clickOnRegisterBtn() {
		actionDriver.click(registerBtn);
	}
	
	public String getEmailalreadyexistsmessage() {
		return actionDriver.getText(emailALreadyExistsMessage);
	}
	
	public String getInvalidEmailMessage() {
		return actionDriver.getText(invalidEmailMessage);
	}
}
