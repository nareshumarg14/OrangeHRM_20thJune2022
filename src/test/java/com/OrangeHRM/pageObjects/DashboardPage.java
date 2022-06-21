package com.OrangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	//1
	public WebDriver driver;
	
	//2. Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3. Locator for Dashboard link
	@FindBy(id="menu_dashboard_index")
	WebElement lnkDashboard;
	
	//4. Method for Dashboard.
	public String dashboardLinkText() {
		String val = lnkDashboard.getText();
		return val;
	}

}
