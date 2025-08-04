package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class CartPage {
	private ActionDriver actionDriver;

	public CartPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	private By cartRemoveCheckbox = By
			.xpath("//table[@class='cart']/tbody/child::tr/td/child::input[@type='checkbox']");

	private By updateCartBtn = By.xpath("//input[@value='Update shopping cart']");
	private By shoppingCartEmptyMessage = By.xpath("//div[@class='page-body']/child::div[contains(text(),'empty')]");

	private By fictionProduct = By.xpath("//table[@class='cart']/tbody/tr/child::td[3]/a");
	private By termsCheckBox = By.xpath("//div[@class='terms-of-service']/child::input");

	private By countryDropdown = By.xpath("//select[@id='CountryId']");

	private By zipcodeTextBox = By.id("ZipPostalCode");

	private By estimateShippingBtn = By.xpath("//input[@value='Estimate shipping']");

	private By checkOutButton = By.id("checkout");

	private By billingAddressDropdown = By.id("billing-address-select");
	private By billingAddressContinueBtn = By.xpath("//div[@id='billing-buttons-container']/child::input");

	private By shippingAddressDropdown = By.id("shipping-address-select");
	private By shippingAddressContinueBtn = By.xpath("//div[@id='shipping-buttons-container']/child::input");

	private By instorePickupCheckbox = By.xpath("//div[@class='section pickup-in-store']/p/child::input[1]");

	private By paymentContinueBtn = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	
	private By paymentInfoContinueBtn = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	
	
	private By orderConfirmContinueBtn = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");
	public void clickOnRemoveCheckbox() {
		actionDriver.click(cartRemoveCheckbox);

	}

	public void clickOnUpdateCartBtn() {
		actionDriver.click(updateCartBtn);

	}

	public String getShoppingCartEmptyMessage() {
		return actionDriver.getText(shoppingCartEmptyMessage);
	}

	public boolean isProductisVisible() {
		return actionDriver.isDisplayed(fictionProduct);

	}

	public void clickOnTermsCheckBox() {
		actionDriver.click(termsCheckBox);

	}

	public void selectShippingCountry() {
		actionDriver.selectByVisibleText(countryDropdown, "India");

	}

	public void enterZipCode() {
		actionDriver.clearText(zipcodeTextBox);
		actionDriver.enterText(zipcodeTextBox, "600002");

	}

	public void clickOnEstimateShippingButton() {
		actionDriver.click(estimateShippingBtn);

	}

	public void clickOnCheckoutButton() {
		actionDriver.click(checkOutButton);

	}

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
