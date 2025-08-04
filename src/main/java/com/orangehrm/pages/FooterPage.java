package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class FooterPage {
	private ActionDriver actionDriver;

	private By followUsLinks = By.xpath("//div[@class='column follow-us']/ul/li");

	public FooterPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
	}

	public void validateAllFollowUsFooterLinks(String url) throws IOException {

		actionDriver.getResponseCodeUrl(url);

	}

}
