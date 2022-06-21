package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.DashboardPage;
import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC001_UserLogin extends BaseClass{
		
	//3. Test Case
	@Test
	public void loginTest() throws IOException {
		String expVal = "Dashboard";
		LoginPage lp = new LoginPage(driver);
		DashboardPage dp = new DashboardPage(driver);
				
		lp.setUsername(prop.getProperty("username"));
		
		lp.setPassword(prop.getProperty("password"));
		
		lp.clickLoginButton();
		String retVal = dp.dashboardLinkText();
		Assert.assertEquals(retVal, expVal,"User did not logged in successfully.....");
		//System.out.println("User has logged into application successfully.....");	
		logger.info("User has logged into application successfully.....");
		capturescreen(driver, "TC001_UserLogin");
	}
	
}
