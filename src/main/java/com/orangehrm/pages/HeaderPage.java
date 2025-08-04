package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class HeaderPage {
	private ActionDriver actionDriver;

	private By registerLink = By.xpath("//a[contains(text(),'Register') or a[@href='/register']]");

	private By loginLink = By.xpath("//a[contains(text(),'Log in') or a[@href='/login']]");

	private By cartLink = By.xpath("//div[@class='header-links']/ul/li[3]/a");

	private By wishListLink = By.xpath("//a[@class='ico-wishlist']/span[1]");

	private By username = By.xpath("//div[@class='header-links']/ul/child::li//a[contains(text(),'RaviTest')]");

	private By logoutLink = By.xpath("//a[contains(text(),'Log out') or a[@href='/Log out']]");

	private By searchBoxField = By.xpath("//input[@id='small-searchterms']");

	private By searchBtn = By.xpath("//form[@action='/search']/child::input[@type='submit']");

	private By electronicsHeaderMenu = By.xpath("//div[@class='header-menu']/child::ul/child::li[3]");

	private By shoppingCartQty = By.xpath("//div[@class='header-links']/ul/child::li[3]/child::a/child::span[2]");
	
	private By shoppingCartHeaderLink =  By.xpath("//div[@class='header-links']/ul/child::li[3]/a");
	
	
	public HeaderPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	public void clickOnLoginHeader() {
		actionDriver.clickUsingJS(loginLink);

	}

	public void clickOnRegisterHeader() {
		actionDriver.clickUsingJS(registerLink);

	}

	public void clickOnCartHeader() {
		actionDriver.click(cartLink);

	}

	public void clickOnWishlistHeader() {
		actionDriver.click(wishListLink);

	}

	public boolean isUserNameDispalyed() {
		return actionDriver.isDisplayed(username);

	}

	public void enterValuesInsideTheSearchBox(String productname) {

		actionDriver.enterText(searchBoxField, productname);

	}

	public void clickOnLogoutHeader() {
		actionDriver.click(logoutLink);

	}

	public void clickOnSearchButton() {

		actionDriver.click(searchBtn);
	}

	public String handleWithoutProductSearchAlert() {

		String alertText = actionDriver.getAlertText();
		actionDriver.acceptAlert();
		return alertText;
	}

	public int getShoppingCartQty() {

		String text = actionDriver.getText(shoppingCartQty);
		String number = text.replaceAll("[^0-9]", "");
		int cartQty=Integer.parseInt(number);
		return cartQty;
	}
	
	public void clickOnShoppingCartHeaderLink() {
		actionDriver.clickUsingJS(shoppingCartHeaderLink);

	}

	



}
