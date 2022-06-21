package com.OrangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//1
	public WebDriver driver;
	
	//2. Defining a constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3. Locator for Username field.
	@FindBy(id="txtUsername")
	WebElement txtUname;
	
	//4. Locator for Password field.
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement txtPwd;
	
	//5. Locator for LOGIN button.
	@FindBy(name="Submit")
	WebElement btnLogin;
	
	@FindBy(linkText="Forgot your password?")
	WebElement lnkForgotyourpassword;
	
	public boolean forgotYourPasswordLinkDisplayed() {
		return lnkForgotyourpassword.isDisplayed();
	}
	
	//6. Method to enter Username
	public void setUsername(String userName) {
		txtUname.clear();
		txtUname.sendKeys(userName);
		String val = txtUname.getAttribute("value");
		System.out.println("Username " + "'" +val + "'" + " is entered!!!!");
	}
	
	//7. Method to enter Password.
	public void setPassword(String passWord) {
		txtPwd.clear();
		txtPwd.sendKeys(passWord);
		String val = txtPwd.getAttribute("value");
		System.out.println("Password " + "'" + val + "'" + " is entered!!!!");
	}
	
	//8. Clicking on Login button.
	public void clickLoginButton() {
		boolean status = btnLogin.isEnabled();
		if (status == true) {
			System.out.println("LOGIN button is enabled and can be clicked....");
			btnLogin.click();
			System.out.println("LOGIN button is clicked!!!!!");
		} else {
			System.out.println("LOGIN button is not enabled and cannot be clicked....");
		}
	}

}
