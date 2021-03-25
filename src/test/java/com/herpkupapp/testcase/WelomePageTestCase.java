package com.herpkupapp.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herpkupapp.pages.WelcomePage;
import com.herpkupapp.testbase.TestBase;

/*
 * This method contains various annotated methods for the test case to run
 */

public class WelomePageTestCase extends TestBase {
	WelcomePage welcomePage;

	public WelomePageTestCase() {
		super(); // need to invoke the property loading of the test base class
	}

	@BeforeMethod
	public void initheroupapp() {
		initialization();
		welcomePage = new WelcomePage();
	}

	@Test
	public void functionalityModule() {
		welcomePage.clickHotemMenu();
		String actualTitle = welcomePage.validateTitle();
		Assert.assertEquals(actualTitle, "Gostays Branded Hotels, Affordable Budget Hotels – Goibibo");
		welcomePage.inputLocation(prop.getProperty("location"));
		welcomePage.searchHotelClick();
		welcomePage.selectRoomandPay();
		welcomePage.payoutMethod();
	}

	@Test
	public void seperateModule() {
		welcomePage.clickHotemMenu();
		String actualTitle = welcomePage.validateTitle();
		Assert.assertEquals(actualTitle, "Gostays Branded Hotels, Affordable Budget Hotels – Goibibo");
		welcomePage.inputLocation(prop.getProperty("location01"));
	}

	@AfterMethod
	public void tear() {
		// driver.quit();
	}

}
