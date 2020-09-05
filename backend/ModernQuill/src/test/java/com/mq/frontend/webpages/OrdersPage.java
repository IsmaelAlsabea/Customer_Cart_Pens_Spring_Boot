package com.mq.frontend.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

	
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id= "orders")
	public WebElement ordersNavBarBtn;
	
	@FindBy(id="header")
	public WebElement ordersPageHeader;
	
	@FindBy(id="firstNamePlusLastName")
	public WebElement customerNameInOrdersPage;
	
}
