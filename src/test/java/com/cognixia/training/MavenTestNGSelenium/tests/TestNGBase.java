package com.cognixia.training.MavenTestNGSelenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestNGBase {
	
	protected WebDriver driver;
	protected WebElement searchbox;
	protected WebElement searchbutton;
	
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Tools\\Selenium\\chromedriver.exe"); //Windows OS
		System.setProperty("webdriver.gecko.driver", "E:\\Tools\\Selenium\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void resetBrowser() {
		driver.navigate().to("https://www.google.com");
		searchbox = driver.findElement(By.name("q"));
		searchbutton = driver.findElement(By.name("btnK"));
	}
	
	public void waitForSuggestionsToLoad(String searchstring) {
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//li[@data-view-type='1']//div[@role='option']"), searchstring));
		
	}
	
	public void waitForTextToBePresentInElement(By e, String text) {
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.textToBePresentInElementLocated(e, text));
		
	}
}