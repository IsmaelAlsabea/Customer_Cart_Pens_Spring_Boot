package com.mq.frontend.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="loginPageHeader")
	public WebElement loginPageHeader;
	
	@FindBy(id = "usernameInput")
	public WebElement username;
	
	@FindBy(id = "passwordInput")
	public WebElement password;
	
	@FindBy(id= "loginButton")
	public WebElement loginButton;
	
	@FindBy(id="wrongCredentialsPopup")
	public WebElement wrongCredentialsPopup;
	
	
}
