package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.HeaderPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.SearchResultsPage;
import com.orangehrm.utilities.ExtentManager;

public class SearchTest extends BaseClass {

	private LoginPage loginPage;

	private HeaderPage headerPage;

	private SearchResultsPage searchPage;

	@BeforeMethod()
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		headerPage = new HeaderPage(getDriver());
		searchPage = new SearchResultsPage(getDriver());
		

	}

	@Test(priority = 1, groups = { "Sanity", "Master" })
	public void TC_008_VerifySearchWithoutAddingAnyProduct() {
		headerPage.clickOnLoginHeader();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ExtentManager.logStep("Clicking on search button");
		try {
			headerPage.clickOnSearchButton();
			logger.info("Validating search alert text");
			Assert.assertEquals("Please enter some search keyword", headerPage.handleWithoutProductSearchAlert());
		} catch (Exception e) {
			logger.error("Search test without any product  is failed : " + e.getMessage());
		}

	}

	@Test(priority = 2, groups = { "Sanity", "Master" })
	public void TC_009_VerifySearchWithValidProduct() {
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
	}

	@Test(priority = 3, groups = { "Sanity", "Master" })
	public void TC_010_VerifySearchWithInvalidProduct() {
		headerPage.clickOnLoginHeader();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			ExtentManager.logStep("Entering invalid product name on the serach field");
			headerPage.enterValuesInsideTheSearchBox("abcd");
			ExtentManager.logStep("Clicking on search button");
			headerPage.clickOnSearchButton();
			ExtentManager.logStep("Validating invalid product searc results");
			Assert.assertEquals("No products were found that matched your criteria.",
					searchPage.getInvalidSearchResultsMessage());
		} catch (Exception e) {
			logger.error("Search test with invalid product  is failed : " + e.getMessage());
			Assert.fail("Search test with invalid product is failed :" + e.getMessage());
		}

	}

	@AfterMethod(groups = { "Sanity", "Master" })
	public void logoutApp() {
		headerPage.clickOnLogoutHeader();

	}

}
