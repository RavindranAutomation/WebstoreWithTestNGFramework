package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class CheckoutPage {
	private ActionDriver actionDriver;

	public CheckoutPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	private By billingAddressDropdown = By.id("billing-address-select");
	private By billingAddressContinueBtn = By.xpath("//div[@id='billing-buttons-container']/child::input");

	private By shippingAddressDropdown = By.id("shipping-address-select");
	private By shippingAddressContinueBtn = By.xpath("//div[@id='shipping-buttons-container']/child::input");

	private By instorePickupCheckbox = By.xpath("//div[@class='section pickup-in-store']/p/child::input[1]");

	private By paymentContinueBtn = By.xpath("//input[@class='button-1 payment-method-next-step-button']");

	private By paymentInfoContinueBtn = By.xpath("//input[@class='button-1 payment-info-next-step-button']");

	private By orderConfirmContinueBtn = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");

	public String getCurrentUrl() {
		return actionDriver.getCurrentURL();

	}

	public void selectBillingAddress() {
		actionDriver.selectByIndex(billingAddressDropdown, 1);

	}

	public void clickOnBillingAddressContinueBtn() {
		actionDriver.click(billingAddressContinueBtn);
	}

	public void selectShippingAddress() {
		actionDriver.selectByIndex(shippingAddressDropdown, 1);

	}

	public void clickOnInstorePickUp() {
		actionDriver.click(instorePickupCheckbox);

	}

	public void clickOnShippingAddressContinueBtn() {
		actionDriver.click(shippingAddressContinueBtn);
	}

	public void clickOnPaymentContinueBtn() {
		actionDriver.click(paymentContinueBtn);

	}

	public void clickOnOrderConfirmConfirmBtn() {
		actionDriver.click(orderConfirmContinueBtn);

	}

	public void clickOnPaymentInforContinueBtn() {
		actionDriver.click(paymentInfoContinueBtn);

	}

}
