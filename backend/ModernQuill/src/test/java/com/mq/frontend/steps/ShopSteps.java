package com.mq.frontend.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.util.UtilFuncsForSeleniumTests;
import com.mq.frontend.webpages.ShopPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopSteps {

	public static ShopPage sPage = PageRunner.sPage;
	public static WebDriver driver = PageRunner.driver;
	

	@When("^the guest clicks on view details of an image$")
	public void the_guest_clicks_on_view_details_of_an_image() throws Throwable {
		UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	    sPage.penDialogButton.click();
	}
	
	@Then("^a pen dialogue pops up$")
	public void a_pen_dialogue_pops_up() throws Throwable{
		 UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
		 Assert.assertTrue(sPage.penDialogueHeader.getText()!="");
	}

	@When("^the guest sets the pen quantity$")
	public void the_guest_sets_the_pen_quantity() throws Throwable {
	    sPage.quantityInputField.sendKeys("14");
	}
	
	@When("^the guest clicks add to cart$")
	public void the_guest_clicks_add_to_cart() throws Throwable {
	    sPage.addToCartBtn.click();
	}

	@Then("^a confirmation pop up will appear$")
	public void a_confirmation_pop_up_will_appear() throws Throwable {
	   Assert.assertTrue(UtilFuncsForSeleniumTests.isAlertPresent());
	   driver.switchTo().alert().dismiss();
	}
}
