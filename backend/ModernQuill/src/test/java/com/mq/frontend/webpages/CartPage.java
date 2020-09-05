package com.mq.frontend.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		
	}

	@FindBy(id= "cart")
	public WebElement cartNavBar;
	
	@FindBy (id="cartPageHeader")
	public WebElement pageHeader;
	
	@FindBy(id="openConfirmOrderDialog")
	public WebElement confirmDialogBtn;
	
	@FindBy(id="placeOrderDialog")
	public WebElement placeOrderDialog;
	
	@FindBy(id="placeOrder")
	public WebElement placeOrderBtn;
	
	@FindBy(id="clearCart")
	public WebElement clearCartBtn;
	
	@FindBy(id="finalCost")
	public WebElement finalCost;
	
	
	
	
	
	
	
	
	
	
}
