package com.mq.frontend.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

	WebDriver driver;

	public ShopPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//shop page
	
	@FindBy(id= "shopPageHeader")
	public WebElement pageheader;
	
	@FindBy(id = "1")
	public WebElement penDialogButton;
	
	//pen-dialog
	
	@FindBy(id="penDialogueHeader")
	public WebElement penDialogueHeader;
	
	@FindBy(id= "quantityInput")
	public WebElement quantityInputField;
	
	@FindBy(id="cartbtn")
	public WebElement addToCartBtn;
	
	@FindBy( id="penAddedToCart")
	public WebElement penAddedAlert;
	
	
	
	
	
	
	
}
