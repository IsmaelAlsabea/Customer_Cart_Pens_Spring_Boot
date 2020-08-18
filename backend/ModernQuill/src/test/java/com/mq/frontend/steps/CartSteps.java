package com.mq.frontend.steps;

import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.webpages.CartPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartSteps {

	public static CartPage cPage = PageRunner.cPage;
	public static WebDriver driver = PageRunner.driver;
	

	@Given("^the guest is on the cart page$")
	public void the_guest_is_on_the_cart_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the guest clicks submit cart order$")
	public void the_guest_clicks_submit_cart_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^confirmation of order is displayed$")
	public void confirmation_of_order_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
