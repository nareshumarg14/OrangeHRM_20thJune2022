package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC002_ForgotYourPasswordLink extends BaseClass{	
	@Test
	public void forgotYourPasswordLinkTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		boolean status = lp.forgotYourPasswordLinkDisplayed();
		Assert.assertTrue(status, "Forgot your password? link is not displayed.....");
		logger.info("Forgot your password? link is displayed.....");
		capturescreen(driver, "TC002_ForgotYourPasswordLink");
	}

}
