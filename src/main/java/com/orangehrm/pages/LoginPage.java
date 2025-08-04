package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class LoginPage {

	private ActionDriver actionDriver;

	// Define locators using By class

	private By emailField = By.xpath("//div[@class='inputs']/child::input[@id='Email']");
	private By passwordField = By.xpath("//div[@class='inputs']/child::input[@id='Password']");
	private By loginButton = By.xpath("//div[@class='buttons']/child::input[@class='button-1 login-button']");
	private By forgotPasswordLink = By.xpath("//div[@class='inputs reversed']/child::span/a");
	private By invalidLoginMessage = By.xpath("//form[@action='/login']/div/div/span[contains(text(),'unsuccessful')]");

	// Initialize the ActionDriver object by passing WebDriver instance
	/*
	 * public LoginPage(WebDriver driver) { this.actionDriver= new
	 * ActionDriver(driver); }
	 */

	public LoginPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	// Method to perform login
	public void login(String userName, String password) {
		actionDriver.enterText(emailField, userName);
		actionDriver.enterText(passwordField, password);
		actionDriver.click(loginButton);
	}

	// Method to check if error message is displayed
	public void clickOnForgotPassword() {
		actionDriver.click(forgotPasswordLink);

	}

	public boolean isInvalidLoginMessageiDispalyed() {
		return actionDriver.isDisplayed(invalidLoginMessage);

	}

}
