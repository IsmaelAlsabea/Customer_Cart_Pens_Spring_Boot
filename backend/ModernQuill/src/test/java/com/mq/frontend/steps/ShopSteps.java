package com.mq.frontend.steps;

import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.webpages.LoginPage;
import com.mq.frontend.webpages.ShopPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopSteps {

	public static ShopPage sPage = PageRunner.sPage;
	public static WebDriver driver = PageRunner.driver;
	
	
	@Given("^the guest is on the shop page$")
	public void the_guest_is_on_the_shop_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the guest clicks add to cart$")
	public void the_guest_clicks_add_to_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^a pop-up box about the pen will appear$")
	public void a_pop_up_box_about_the_pen_will_appear() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the guest is in the pop-up box of a pen$")
	public void the_guest_is_in_the_pop_up_box_of_a_pen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the guest sets the quantity and click add to cart$")
	public void the_guest_sets_the_quantity_and_click_add_to_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the pen is added to the cart$")
	public void the_pen_is_added_to_the_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
