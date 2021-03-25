package com.herpkupapp.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.herpkupapp.testbase.TestBase;

public class HerpkuappUtil extends TestBase {

	public static long PAGE_LOAD_TIME_OUT = 10;
	public static long IMPLICIT_WAIT = 50;
	public static long LOCATION_WAIT = 5;

	public void screenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("./screenshotsnew/sku.png"));
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("Unable to take screen shot");
		}
	}

}
