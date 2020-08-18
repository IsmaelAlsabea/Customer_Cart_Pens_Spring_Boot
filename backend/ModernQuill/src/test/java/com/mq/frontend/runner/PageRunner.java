package com.mq.frontend.runner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mq.frontend.webpages.CartPage;
import com.mq.frontend.webpages.LoginPage;
import com.mq.frontend.webpages.ShopPage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.mq.frontend.steps") 
public class PageRunner {

	public static WebDriver driver;

	
	public static CartPage cPage;
	public static LoginPage loginPage;
	public static ShopPage sPage;
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());	
		
		driver = new ChromeDriver();
		
		cPage = new CartPage(driver);	
		loginPage = new LoginPage(driver);
		sPage= new ShopPage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
}