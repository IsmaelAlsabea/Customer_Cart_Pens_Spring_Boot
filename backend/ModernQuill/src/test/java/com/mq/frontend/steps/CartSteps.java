package com.mq.frontend.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.util.UtilFuncsForSeleniumTests;
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
	    cPage.cartNavBar.click();
		UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
		Assert.assertEquals("Your cart:", cPage.pageHeader.getText());
	}

	@When("^the guest clicks confirm order to open confirm order dialog$")
	public void the_guest_clicks_confirm_order_to_open_confirm_order_dialog() throws Throwable {
	    cPage.confirmDialogBtn.click();
	}

	@Then("^Another confirmation order dialog opens$")
	public void another_confirmation_order_dialog_opens() throws Throwable {
	    UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	    Assert.assertEquals("Order Confirmation", cPage.placeOrderDialog.getText());
	    
	}

	@When("^the customer clicks confirm order$")
	public void the_customer_clicks_confirm_order() throws Throwable {
	    cPage.placeOrderBtn.click();
	    UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	}
	
	
	@When("^the guest clicks clear cart$")
	public void the_guest_clicks_clear_cart() throws Throwable {
	   cPage.clearCartBtn.click();
	}

	@Then("^cart gets cleared$")
	public void cart_gets_cleared() throws Throwable {
	    Assert.assertEquals("$0.00", cPage.finalCost.getText());
	}


}
