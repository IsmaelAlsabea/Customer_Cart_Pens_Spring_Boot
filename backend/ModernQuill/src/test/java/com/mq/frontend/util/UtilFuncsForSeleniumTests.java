package com.mq.frontend.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mq.frontend.runner.PageRunner;

public class UtilFuncsForSeleniumTests {

	private static WebDriverWait wait = PageRunner.wait; 
	
	public static void waitWithoutExpectedConditions() {
		
		//code below will force selenium to wait without expected condition specified	
		try {
			wait.until(ExpectedConditions.attributeContains(By.id("- - - "), "class", "poieuwr"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	public static boolean isAlertPresent () {
		if (wait.until(ExpectedConditions.alertIsPresent())!=null)
			return true;
		return false;

	}
	

	public static boolean isAlertPresent(WebElement e) {
		
		try {
			if (e.isDisplayed())	
				return true;
			return false;
		} catch(org.openqa.selenium.NoSuchElementException ex) {
			return false;
		}
		
	}
	
	
}
