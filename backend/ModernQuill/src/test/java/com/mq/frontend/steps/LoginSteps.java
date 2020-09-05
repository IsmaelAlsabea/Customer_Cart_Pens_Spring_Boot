package com.mq.frontend.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.util.UtilFuncsForSeleniumTests;
import com.mq.frontend.webpages.LoginPage;
import com.mq.frontend.webpages.ShopPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	public static LoginPage loginPage = PageRunner.loginPage;
	public static ShopPage sPage = PageRunner.sPage;
	public static WebDriver driver = PageRunner.driver;
	
	@Given("^the guest is on the login$")
	public void the_guest_is_on_the_login() throws Throwable {
	    driver.get("http://localhost:4200/login");
	}

	@When("^the guest enters their email$")
	public void the_guest_enters_their_email() throws Throwable {
	    loginPage.username.sendKeys("penguy37@gmail.com");
	}

	@When("^the guest enters their password$")
	public void the_guest_enters_their_password() throws Throwable {
		loginPage.password.sendKeys("pen123");
	}

	@When("^the guest clicks login$")
	public void the_guest_clicks_login() throws Throwable {
	    loginPage.loginButton.click();
	}

	@Then("^the guest should be on shop page$")
	public void the_guest_should_be_on_shop_page() throws Throwable {
		UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
		Assert.assertEquals("Shop Page", sPage.pageheader.getText());
	}
	
	
	@When("^the guest enters their wrong email$")
	public void the_guest_enters_their_wrong_email() throws Throwable {
		 Assert.assertFalse(UtilFuncsForSeleniumTests.isAlertPresent(loginPage.wrongCredentialsPopup));
		loginPage.username.sendKeys("kshflksdfsjl");
	}

	@When("^the guest enters their wrong password$")
	public void the_guest_enters_their_wrong_password() throws Throwable {
		Assert.assertFalse(UtilFuncsForSeleniumTests.isAlertPresent(loginPage.wrongCredentialsPopup));
		loginPage.password.sendKeys("sakljdflsdjflsdjfls");
	}
	
	@Then("^an alert pops up telling user that credentials are wrong$")
	public void an_alert_pops_up_telling_user_that_credentials_are_wrong() throws Throwable {
	    UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	    Assert.assertTrue(UtilFuncsForSeleniumTests.isAlertPresent(loginPage.wrongCredentialsPopup));
	    
	    
//	    Assert.assertEquals("Modern Quill", loginPage.loginPageHeader.getText());
//	    UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	}


	
	
	
	
	
	
	
	
	
	
}
