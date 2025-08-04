package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class PasswordRecoveryPage {
	private ActionDriver actionDriver;

	private By passwordRecoveryTitle = By.xpath("//div[@class='page-title']/child::h1[contains(text(),'recovery')]");
	private By passwordRecoveryEmailField = By.xpath("//div[@class='inputs']/child::input");
	private By recoveryBtn = By.xpath("//div[@class='buttons']/child::input[@name='send-email']");
	private By passwordRecoveryInstructionMessage = By
			.xpath("//div[@class='page-title']/following::div/child::div[contains(text(),'instructions')]");

	public PasswordRecoveryPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	public boolean isPasswordRecoveryTitleisDisplayed() {
		return actionDriver.isDisplayed(passwordRecoveryTitle);

	}

	public void enterEmailInRecoveryEmailField() {
		actionDriver.enterText(passwordRecoveryEmailField, "RaviTest@yopmail.com");

	}

	public void clickOnRecoveryBtn() {
		actionDriver.clickUsingJS(recoveryBtn);

	}

	public String getRecoveryInstructionMessage() {
		return actionDriver.getText(passwordRecoveryInstructionMessage);

	}

}
