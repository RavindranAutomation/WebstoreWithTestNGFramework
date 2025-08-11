package com.orangehrm.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.CartPage;
import com.orangehrm.pages.CheckoutPage;
import com.orangehrm.pages.HeaderPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.OrderCompltetionPage;
import com.orangehrm.pages.SearchResultsPage;
import com.orangehrm.utilities.ExtentManager;

public class CheckoutTest extends BaseClass {

	private LoginPage loginPage;

	private HeaderPage headerPage;

	private SearchResultsPage searchPage;
	public static final Logger logger = BaseClass.logger;

	private CartPage cartpage;
	private CheckoutPage checkoutPage;

	private OrderCompltetionPage orderCompletionPage;
	int shoppingCartQty;

	@BeforeMethod()
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		headerPage = new HeaderPage(getDriver());
		searchPage = new SearchResultsPage(getDriver());
		cartpage = new CartPage(getDriver());
		checkoutPage = new CheckoutPage(getDriver());
		orderCompletionPage = new OrderCompltetionPage(getDriver());
	}



	@Test(priority = 1)
	public void TC_013_Verify_CheckoutwithExistingAddress() {
		logger.info(
				"******************** Starting Test - TC_013_Verify_CheckoutPage_Navigation ************************");

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
		cartpage.selectShippingCountry();
		cartpage.enterZipCode();
		cartpage.clickOnEstimateShippingButton();
		cartpage.clickOnTermsCheckBox();
		cartpage.clickOnCheckoutButton();
		Assert.assertEquals(checkoutPage.getCurrentUrl(), "https://demowebshop.tricentis.com/onepagecheckout");

		checkoutPage.selectBillingAddress();
		checkoutPage.clickOnBillingAddressContinueBtn();

		checkoutPage.selectShippingAddress();
		cartpage.clickOnInstorePickUp();
		checkoutPage.clickOnShippingAddressContinueBtn();
		checkoutPage.clickOnPaymentContinueBtn();
		checkoutPage.clickOnPaymentInforContinueBtn();
		checkoutPage.clickOnOrderConfirmConfirmBtn();

		Assert.assertTrue(orderCompletionPage.isOrderSuccessMessageDisplayed());

		int orderId = orderCompletionPage.getOrderNumber();

		System.out.println(orderId);

	}

	@AfterMethod
	public void logoutApp() {
		headerPage.clickOnLogoutHeader();
		logger.info("******************** Ending Test ************************");
	}

}
