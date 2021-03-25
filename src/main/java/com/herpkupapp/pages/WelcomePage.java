package com.herpkupapp.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herpkupapp.testbase.TestBase;

/*
 * this method contains all the page factory for the webleements need to be used
 */

public class WelcomePage extends TestBase {

	JavascriptExecutor jsx = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[@href='/gostays/']//span[@class='iconText'][normalize-space()='Hotels']")
	WebElement HotelMenu;
	@FindBy(xpath = "//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")
	WebElement inputEle;
	@FindBy(xpath = "//ul[@id='downshift-1-menu']")
	WebElement autoSuggestEle;
	@FindBy(xpath = "//button[contains(text(),'Search Hotels')]")
	WebElement searchHotelsEle;
	@FindBy(xpath = "//button[contains(text(),'UPDATE SEARCH')]")
	WebElement updateSearchEle;
	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/div[1]")
	WebElement hoteliconEle;
	@FindBy(xpath = "//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-10 RoomFlavorstyles__ButtonWrapper-sc-1btnl3r-15 dTNRom bCgKhF']")
	WebElement selectRoomsEle;
	@FindBy(xpath = "//h4[contains(text(),'Congratulations you have picked a Top-Rated Budget Property')]")
	WebElement cgtMsg;
	@FindBy(xpath = "//h4[contains(text(),'GUEST DETAILS')]")
	WebElement guestDtxEle;
	@FindBy(xpath = "//input[@placeholder='Enter First Name']")
	WebElement firstNameEle;
	@FindBy(xpath = "//input[@placeholder='Enter Last Name']")
	WebElement lastNameEle;
	@FindBy(xpath = "//input[@placeholder='Enter Email Address']")
	WebElement emailAddEle;
	@FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
	WebElement phoneNumberEle;
	@FindBy(xpath = "//button[contains(text(),'Proceed To Payment Options')]")
	WebElement payoutEle;

	@FindBy(xpath = "//h4[contains(text(),'PAYMENT MODE')]")
	WebElement payModeEle;
	@FindBy(xpath = "//input[@placeholder='Card Number']")
	WebElement cardNumberEle;
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement cardNameEle;
	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	WebElement dateEle;
	@FindBy(xpath = "//input[@placeholder='CVV NO.']")
	WebElement cvvEle;

	@FindBy(xpath = "//input[@placeholder='811 North Cataline Avenue, No.3002']")
	WebElement addressLineEle;
	@FindBy(xpath = "//input[@placeholder='560076']")
	WebElement zipcodeEle;
	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement cityEle;
	@FindBy(xpath = "//input[@placeholder='State']")
	WebElement StateEle;
	@FindBy(xpath = "//div[@class='col-md-6 col-sm-6 col-xs-12 pad0 displayFlex']//button[@class='button green large citipatBtn btn payNowBtn']")
	WebElement payNoeEle;
	@FindBy(xpath = "//span[@class='red lh1-5 ico14 fl width100']")
	WebElement messageErrorEle;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/section/div[1]/div[1]/ul/li[1]/div/span")
	WebElement allhotelsEle;
	@FindBy(xpath = "//h4[contains(text(),'Hotel Silver Oak')]")
	WebElement silveroakEle;
	@FindBy(xpath = "//h1[contains(text(),'Hotel Silver Oak')]")
	WebElement hotelNameEle;
	@FindBy(xpath = "//a[contains(text(),'Location')]")
	WebElement LocationMenuOotyEle;
	@FindBy(xpath = "//a[contains(text(),'Guest Reviews')]")
	WebElement guesrReviewsEle;
	@FindBy(xpath = "//a[contains(text(),'Questions & Answers')]")
	WebElement questionEle;
	@FindBy(xpath = "//a[contains(text(),'Hotel Policies')]")
	WebElement hotelpolicyEle;

	// need to invoke the page factory
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickHotemMenu() {
		HotelMenu.click();
	}

	public String validateTitle() {
		return driver.getTitle();
	}

	public void inputLocation(String location) {
		if(location.equalsIgnoreCase("Mysore")) {
			inputEle.sendKeys(prop.getProperty("location"));
			autoSuggestEle.click();
		}else if(location.equalsIgnoreCase("Ooty")) {
			inputEle.sendKeys(prop.getProperty("location01"));
			autoSuggestEle.click();
			searchHotelsEle.click();
			updateSearchEle.click();
			allhotelsEle.click();
			silveroakEle.click();
			switchWindow(silveroakEle);
		}else {
			System.out.println("location is empty");
		}
	}

	private void switchWindow(WebElement silveroakEle) {

		String parentWindow = driver.getWindowHandle();
		Set<String> childwindowSet = driver.getWindowHandles();
		// to iterate through all the child windows
		Iterator<String> it = childwindowSet.iterator();
		while (it.hasNext()) {
			String childwindowValue = it.next();
			if (!parentWindow.equalsIgnoreCase(childwindowValue)) {
				driver.switchTo().window(childwindowValue);
				System.out.println("Name of the hotel is : " + hotelNameEle.getText());
				LocationMenuOotyEle.click();
				guesrReviewsEle.click();
				questionEle.click();
				hotelpolicyEle.click();
			}
		}
	}

	public void searchHotelClick() {
		searchHotelsEle.click();
		updateSearchEle.click();
		hoteliconEle.click();
	}

	public void selectRoomandPay() {
		String parentWindow = driver.getWindowHandle();
		Set<String> childwindowSet = driver.getWindowHandles();
		// to iterate through all the child windows
		Iterator<String> it = childwindowSet.iterator();
		while (it.hasNext()) {
			String childwindowValue = it.next();
			if (!parentWindow.equalsIgnoreCase(childwindowValue)) {
				driver.switchTo().window(childwindowValue);
				jsx.executeScript("window.scrollBy(0,550)", "");
				selectRoomsEle.click();
				String congratsMessage = cgtMsg.getText();
				if (congratsMessage != null && congratsMessage != "") {
					jsx.executeScript("window.scrollBy(0,700)", "");
					guestDetailsForm(guestDtxEle);
				}
			}
		}
	}

	// method to fill the guest details form in the webpage
	private void guestDetailsForm(WebElement guestDtxEle) {
		String value = guestDtxEle.getText();
		if (value.equalsIgnoreCase("GUEST DETAILS")) {
			firstNameEle.sendKeys(prop.getProperty("firstaName"));
			lastNameEle.sendKeys(prop.getProperty("lastName"));
			emailAddEle.sendKeys(prop.getProperty("emailAddress"));
			phoneNumberEle.sendKeys(prop.getProperty("phoneNumber"));
		}

	}

	public void payoutMethod() {
		payoutEle.click();
		paymentMode(payModeEle);
	}

	private void paymentMode(WebElement payModeEle) {
		String errorMessage = null;
		// method to enter the payment details that is the card details
		String textElement = payModeEle.getText();
		if (textElement.equalsIgnoreCase("PAYMENT MODE")) {
			// enter the payment details
			cardNumberEle.sendKeys(prop.getProperty("cardNumber"));
			cardNameEle.sendKeys(prop.getProperty("nameonthecard"));
			dateEle.sendKeys(prop.getProperty("expiryDate"));
			cvvEle.sendKeys(prop.getProperty("cvvno"));
			/*
			 * addressLineEle.sendKeys(prop.getProperty("address"));
			 * zipcodeEle.sendKeys(prop.getProperty("zipcode"));
			 * cityEle.sendKeys(prop.getProperty("city"));
			 * StateEle.sendKeys(prop.getProperty("state"));
			 */
			payNoeEle.click();
			errorMessage = messageErrorEle.getText();
			System.out.println("Error in transaction : " + errorMessage);
		}
	}
}
