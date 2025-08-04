package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class OrderCompltetionPage {

	private ActionDriver actionDriver;

	public OrderCompltetionPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	private By orderSuccessMessage = By.xpath("//div[@class='title']");
	private By orderNumber = By.xpath("//ul[@class='details']/child::li[1]");

	public boolean isOrderSuccessMessageDisplayed() {
		return actionDriver.isDisplayed(orderSuccessMessage);
	}

	public int getOrderNumber() {

		String orderNumberString = actionDriver.getText(orderNumber);
		String[] splittedString = orderNumberString.split(":");
		String num = splittedString[1];
		String num2 = num.trim();

		int ordernumber = Integer.parseInt(num2);

		return ordernumber;
	}

}
