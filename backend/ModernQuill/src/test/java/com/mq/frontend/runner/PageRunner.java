package com.mq.frontend.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mq.frontend.webpages.CartPage;
import com.mq.frontend.webpages.LoginPage;
import com.mq.frontend.webpages.LogoutPage;
import com.mq.frontend.webpages.OrdersPage;
import com.mq.frontend.webpages.ShopPage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.mq.frontend.steps") 
public class PageRunner {

	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static CartPage cPage;
	public static LoginPage loginPage;
	public static LogoutPage LogoutPage;
	public static ShopPage sPage;
	public static OrdersPage oPage;
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());	
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,2);
		
		
		cPage = new CartPage(driver);	
		loginPage = new LoginPage(driver);
		LogoutPage= new LogoutPage(driver);
		sPage= new ShopPage(driver);
		oPage= new OrdersPage(driver);
		
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
}