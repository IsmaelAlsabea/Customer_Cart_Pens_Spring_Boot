package com.mq.frontend.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mq.frontend.runner.PageRunner;
import com.mq.frontend.util.UtilFuncsForSeleniumTests;
import com.mq.frontend.webpages.OrdersPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrdersSteps {

	public static WebDriver driver = PageRunner.driver;
	private static OrdersPage oPage= PageRunner.oPage;
	
	
	
	
	@When("^Customer clicks on orders$")
	public void customer_clicks_on_orders() throws Throwable {
	    oPage.ordersNavBarBtn.click();
	}

	@Then("^Customer gets redirected to his Orders Page\\.$")
	public void customer_gets_redirected_to_his_Orders_Page() throws Throwable {
		UtilFuncsForSeleniumTests.waitWithoutExpectedConditions();
	    Assert.assertEquals("Orders Summary", oPage.ordersPageHeader.getText());
	    Assert.assertEquals("Mr. Pen", oPage.customerNameInOrdersPage.getText());
	}
}
