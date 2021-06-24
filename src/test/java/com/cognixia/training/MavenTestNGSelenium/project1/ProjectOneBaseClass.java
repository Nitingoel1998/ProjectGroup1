package com.cognixia.training.MavenTestNGSelenium.project1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ProjectOneBaseClass {
	protected WebDriver driver;
	protected WebElement searchbox;
	protected WebElement searchbutton;
	
	
	@BeforeTest
	public void openBrowser() {
		String browser = "Firefox";
		System.setProperty("webdriver.chrome.driver", "E:\\Tools\\Selenium\\chromedriver.exe"); //Windows OS
		System.setProperty("webdriver.gecko.driver", "E:\\Tools\\Selenium\\geckodriver.exe");
		switch (browser) {
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("You requested for another browser which is not available. Hence running this script on Google Chrome");
			driver = new ChromeDriver();
			break;
		}
		driver.get("https://www.cleartrip.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

	@AfterTest
	protected void tearDown() {
		System.out.println("TEAM 1 Project 1 Automation Testing Completed");
		driver.close();
		driver.quit();
	}
	void screenShot() throws IOException {
		File f;
		f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("ScreenshotOfClearTrip/allflights.jpg"));
		
	}
	void screenShot2() throws IOException {
		File f;
		f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("ScreenshotOfClearTrip/nonstopflights.jpg"));
		
	}
	protected void waitForTitleToContain(String searchstring) {
		WebDriverWait myWait = new WebDriverWait(driver, 60);
		myWait.until(ExpectedConditions.titleContains(searchstring));
	}
	protected void waitForTextToBePresentInElement(By e, String text) {
		WebDriverWait myWait = new WebDriverWait(driver, 30);
		myWait.until(ExpectedConditions.textToBePresentInElementLocated(e, text));
	}
}