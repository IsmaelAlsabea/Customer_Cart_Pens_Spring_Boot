package com.mq.frontend.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.util.UtilFuncsForSeleniumTests;
import com.mq.frontend.webpages.LoginPage;
import com.mq.frontend.webpages.LogoutPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogOutSteps {

	public static LoginPage loginPage = PageRunner.loginPage;

	public static LogoutPage logoutPage= PageRunner.LogoutPage;
	public static WebDriver driver = PageRunner.driver;
	
	@When("^the customer clicks logout$")
	public void the_customer_clicks_logout() throws Throwable {
	    logoutPage.logoutBtn.click();
	}

	@Then("^the program will redirect customer to the login page$")
	public void the_program_will_redirect_customer_to_the_login_page() throws Throwable {
	    UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	    Assert.assertEquals("Modern Quill", loginPage.loginPageHeader.getText());
	    UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	}

}
