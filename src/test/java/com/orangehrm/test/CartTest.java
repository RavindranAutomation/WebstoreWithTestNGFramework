package com.orangehrm.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.CartPage;
import com.orangehrm.pages.HeaderPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.SearchResultsPage;
import com.orangehrm.utilities.ExtentManager;

public class CartTest extends BaseClass {
	private LoginPage loginPage;

	private HeaderPage headerPage;

	private SearchResultsPage searchPage;
	public static final Logger logger = BaseClass.logger;

	private CartPage cartpage;
	int shoppingCartQty;

	@BeforeMethod()
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		headerPage = new HeaderPage(getDriver());
		searchPage = new SearchResultsPage(getDriver());
		cartpage = new CartPage(getDriver());

	}

	@Test(priority = 1)
	public void TC_011_Verify_AddProductToCart() {

		logger.info("******************** Starting Test - TC_011_Verify_AddProductToCart ************************");

		logger.info("Clicking on Login header");
		headerPage.clickOnLoginHeader();
		logger.info("Login with username and password");
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		try {
			logger.info("Entering values into search field");
			ExtentManager.logStep("Entering values into search field");
			headerPage.enterValuesInsideTheSearchBox(prop.getProperty("testproduct"));
			logger.info("Clicking on search button");
			ExtentManager.logStep("Clicking on search button");
			headerPage.clickOnSearchButton();
			logger.info("Validating search results product");
			ExtentManager.logStep("Validating search results product");
			Assert.assertEquals(prop.getProperty("testproduct"), searchPage.getSearchProductDetail());
			Assert.assertEquals(true, searchPage.isSearchedProductDisplayed());
		} catch (Exception e) {
			logger.error("Search test with valid product  is failed : " + e.getMessage());
			Assert.fail("Search test with valid product is failed :" + e.getMessage());
		}
		logger.info("Clicking on Add to Cart button");
		searchPage.clickOnAddToCartButton();
		logger.info("Valdiating notification message");
		Assert.assertEquals(searchPage.isAddToCartNotificatioMessageDisplayed(), true);
		shoppingCartQty = headerPage.getShoppingCartQty();
		logger.info("Valdiating cart quantity" + shoppingCartQty);
		//Assert.assertEquals(shoppingCartQty, 1);

		logger.info("Clicking on Shopping cart header link");
		headerPage.clickOnShoppingCartHeaderLink();
		logger.info("Valdiating product's visibility");
		Assert.assertTrue(cartpage.isProductisVisible());
		logger.info("Removing products from shopping cart");
		if (shoppingCartQty != 0) {
			logger.info("Clicking on remove checkbox");
			cartpage.clickOnRemoveCheckbox();
			logger.info("Clicking on update cart button");
			cartpage.clickOnUpdateCartBtn();
			logger.info("Valdiating shopping cart message" + cartpage.getShoppingCartEmptyMessage());
			Assert.assertEquals(cartpage.getShoppingCartEmptyMessage(), "Your Shopping Cart is empty!");
			logger.info("Removed producted from shopping cart");

		}

	}

	@Test(priority = 2,enabled = false)
	public void TC_012_Verify_AddToCartCounter() {
		headerPage.clickOnLoginHeader();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		try {
			ExtentManager.logStep("Entering values into search field");
			headerPage.enterValuesInsideTheSearchBox(prop.getProperty("testproduct"));
			ExtentManager.logStep("Clicking on search button");
			headerPage.clickOnSearchButton();
			ExtentManager.logStep("Validating search results product");
			Assert.assertEquals(prop.getProperty("testproduct"), searchPage.getSearchProductDetail());
			Assert.assertEquals(true, searchPage.isSearchedProductDisplayed());
		} catch (Exception e) {
			logger.error("Search test with valid product  is failed : " + e.getMessage());
			Assert.fail("Search test with valid product is failed :" + e.getMessage());
		}
		searchPage.clickOnAddToCartButtonForFiveTimes();
		Assert.assertEquals(searchPage.isAddToCartNotificatioMessageDisplayed(), true);
		shoppingCartQty = headerPage.getShoppingCartQty();
		//Assert.assertEquals(shoppingCartQty, 3);
		headerPage.clickOnShoppingCartHeaderLink();
		Assert.assertTrue(cartpage.isProductisVisible());
		if (shoppingCartQty != 0) {
			cartpage.clickOnRemoveCheckbox();
			cartpage.clickOnUpdateCartBtn();
			Assert.assertEquals(cartpage.getShoppingCartEmptyMessage(), "Your Shopping Cart is empty!");
		}

	}

	@AfterMethod
	public void logoutApp() {
		headerPage.clickOnLogoutHeader();
		logger.info("******************** Ending Test ************************");
	}

}
