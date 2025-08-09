package com.cab.cucumber.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cab.cucumber.utils.Reports;

public class HomePage extends BasePage{
	
	private static final Logger log = LogManager.getLogger(HomePage.class);
	

	//WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath = "//a[text() = 'Home']") public WebElement home;
	@FindBy(xpath="//a[text()='About']") WebElement about;
	@FindBy(xpath="//a[text()='Services']") public WebElement service;
	@FindBy(xpath="//a[text()='Booking']") WebElement booking;
	@FindBy(xpath="//a[text()='Contact']") WebElement contact;
	
	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	public boolean clickService() {
		try {
			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(service));
			log.info("Clicking Services link");
			a.click();
			Reports.generateReport(driver, test, Status.PASS, "Service link clicked successfully" );
		}catch(Exception e) {
			log.error("Services link could not be clicked");
			Reports.generateReport(driver, test, Status.FAIL, "Service link could not be clicked");
			return false;
			
		}
		return true;
	}
	
	public boolean clickBooking() {
		try {
			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(booking));
			log.info("Clicking Booking link");
			a.click();
			Reports.generateReport(driver, test, Status.PASS, "Booking link clicked successfully" );
		}catch(Exception e) {
			log.error("Booking link could not be clicked");
			Reports.generateReport(driver, test, Status.FAIL, "Booking link could not be clicked");
			return false;
			
		}
		return true;
	}
	
	
}
