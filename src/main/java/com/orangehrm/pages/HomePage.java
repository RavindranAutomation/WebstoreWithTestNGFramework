package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class HomePage {

	private ActionDriver actionDriver;

	private By registrationSuccessMsgElement = By.xpath("//div[contains(text(),'Your registration completed')]");

	// Initialize the ActionDriver object by passing WebDriver instance
	/*
	 * public HomePage(WebDriver driver) { this.actionDriver= new
	 * ActionDriver(driver); }
	 */

	public HomePage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	public String getRegisterSuccessMessage() {

		return actionDriver.getText(registrationSuccessMsgElement);

	}
}
