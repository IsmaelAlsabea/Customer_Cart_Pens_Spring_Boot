package com.mq.frontend.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.util.WaitUtil;
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
		WaitUtil.waitWithoutExpectedConditions(driver);
		Assert.assertEquals("Shop Page", sPage.pageheader.getText());
	}
}
