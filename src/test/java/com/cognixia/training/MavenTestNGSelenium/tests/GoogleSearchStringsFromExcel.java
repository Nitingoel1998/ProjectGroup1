package com.cognixia.training.MavenTestNGSelenium.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognixia.training.MavenTestNGSelenium.common.ReadFromExcel;

public class GoogleSearchStringsFromExcel  extends TestNGBase{

	@Test (dataProvider = "getDataFromExcel")
	public void myTest(String searchstring, String expectedstring) {
		String searchstrings = searchstring;
		searchbox.sendKeys(searchstrings);
		searchbox.submit();
		String expected = expectedstring;
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);

	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException {
		return ReadFromExcel.readExcelData("resources/googleAutomationTestData.xlsx");
	}
}
