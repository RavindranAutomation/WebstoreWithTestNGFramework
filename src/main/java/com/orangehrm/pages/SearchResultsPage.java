package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class SearchResultsPage {
	private ActionDriver actionDriver;

	private By searchPageTitle = By.xpath("//div[@class='page-title']/child::h1[contains(text(),'Search')]");
	private By searchValueAttribute = By.xpath("//div[@class='inputs']/child::input");
	private By searchResultProduct = By.xpath("//h2[@class='product-title']/child::a");
	private By addToCartBtn = By.xpath("//div[@class='buttons']/child::input[@value='Add to cart']");
	private By invalidSearchResultsMessage = By
			.xpath("//div[@class='search-results']/strong[contains(text(),'No products')]");
	private By addToCartButton = By.xpath("//h2[@class='product-title']//following::input");
	private By addToCartNotificatioMessage = By.xpath("//div[@id='bar-notification']");
	private By addToCartNotificationMessageCloseButton = By.xpath("//div[@id='bar-notification']/child::span");

	public SearchResultsPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	public boolean isSearchPageTitleDisplayed() {
		return actionDriver.isDisplayed(searchPageTitle);

	}

	public String getSearchProductDetail() {

		return actionDriver.getAttributeValue(searchValueAttribute, "value");

	}

	public boolean isSearchedProductDisplayed() {

		return actionDriver.isDisplayed(searchResultProduct);

	}

	public String getInvalidSearchResultsMessage() {

		return actionDriver.getText(invalidSearchResultsMessage);

	}

	public void clickOnAddToCartButton() {

		actionDriver.clickUsingJS(addToCartBtn);

	}

	public boolean isAddToCartNotificatioMessageDisplayed() {

		return actionDriver.isDisplayed(addToCartNotificatioMessage);

	}

	public void closeAddToCartNotificationMessage() {
		actionDriver.clickUsingJS(addToCartNotificationMessageCloseButton);

	}

	public void clickOnAddToCartButtonForFiveTimes() {

		for (int i = 0; i < 5; i++) {
			actionDriver.click(addToCartBtn);
		}

	}
}
