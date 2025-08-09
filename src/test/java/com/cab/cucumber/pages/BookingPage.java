package com.cab.cucumber.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cab.cucumber.utils.Reports;

	

public class BookingPage extends BasePage{
	private static final Logger log=LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath="//input[@id='fullname']") WebElement fullName;
	@FindBy(xpath="//input[@id='phonenumber']") WebElement phoneNumber;
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//input[@id='long']") WebElement longTrip;
	@FindBy(xpath="//input[@id='local']") WebElement localTrip;
	@FindBy(xpath="//select[@id='cabselect']") WebElement cabSelect;
	@FindBy(xpath="//input[@id='oneway']") WebElement oneWay;
	@FindBy(xpath="//input[@id='roundtrip']") WebElement roundTrip;
	@FindBy(xpath="//button[@id='submitted']") WebElement bookNow;
	@FindBy(xpath = "//select[@id='cabType']") WebElement carType;
	@FindBy(xpath = "//input[@id='pickupdate']") WebElement date;
	@FindBy(xpath = "//input[@id='pickuptime']") WebElement pickUpTime;
	@FindBy(xpath = "//select[@id='passenger']") WebElement noOfPassenger;
	@FindBy(xpath = "//table[@id = 'display']//tr[1]") WebElement checkTable;
	
	
	
	public BookingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public boolean enterName(String name) {
		try {
			
			fullName.sendKeys(name);
			log.info("Name successfully sent");
			Reports.generateReport(driver, test, Status.PASS, name+" successfully entered");
		}catch(Exception e) {
			log.error("Name could not sent");
			Reports.generateReport(driver, test, Status.FAIL, name+" could not be entered");
			return false;
		}
		return true;
	}
	
	
	public boolean enterPhone(String phone) {
		try {
			
			phoneNumber.sendKeys(phone);
			log.info("Phone number successfully sent");
			Reports.generateReport(driver, test, Status.PASS, phone+" successfully entered");
		}catch(Exception e) {
			log.error("Phone number could not sent");
			Reports.generateReport(driver, test, Status.FAIL, phone+" could not be entered");
			return false;
		}
		return true;
	}
	
	public boolean enterMail(String mail) {
		try {
			
			email.sendKeys(mail);
			log.info("Mail successfully sent");
			Reports.generateReport(driver, test, Status.PASS, mail+" successfully entered");
		}catch(Exception e) {
			log.error("Mail could not sent");
			Reports.generateReport(driver, test, Status.FAIL, mail+" could not be entered");
			return false;
		}
		return true;
	}
	
	public boolean clickTripType(String type) {
		try {
			if(type.equals("longTrip")) {
				longTrip.click();
				log.info("Long trip successfully clicked");
				Reports.generateReport(driver, test, Status.PASS, type+" successfully clicked");
				
			}else if(type.equals("localTrip")){
				localTrip.click();
				log.info("Local trip successfully clicked");
				Reports.generateReport(driver, test, Status.PASS, type+" successfully clicked");
			}
		return true;
		}catch(Exception e) {
			log.error("Trip not selected");
			Reports.generateReport(driver, test, Status.FAIL, type+" could not be clicked");
			return false;
		}
	}
	
	public boolean selectCab(String cab) {
		try {
			cabSelect.click();
			Select sel = new Select(cabSelect);
			sel.selectByVisibleText(cab);
			log.info("cab successfully selected");
			Reports.generateReport(driver, test, Status.PASS, cab+" successfully selected");
			return true;
		}catch(Exception e) {
			log.error("cab could not be selected");
			Reports.generateReport(driver, test, Status.FAIL, cab+" could not be selected");
			return false;
		}
	}
	
	public boolean selectCarType(String cartype) {
		try {
			carType.click();
			Select sel = new Select(carType);
			sel.selectByVisibleText(cartype);
			log.info("car type selected");
			Reports.generateReport(driver, test, Status.PASS, cartype+" successfully selected");
			return true;
		}catch(Exception e) {
			log.error("car type not selected");
			Reports.generateReport(driver, test, Status.FAIL, cartype+" could not be selected");
			return false;
		}
	}
	
	
	public boolean sendDate(String d) {
		try {
			date.sendKeys(d);
			log.info("date selected");
			Reports.generateReport(driver, test, Status.PASS, d+" successfully selected");
			return true;
		}catch(Exception e) {
			log.error("date not selected");
			Reports.generateReport(driver, test, Status.FAIL, d+" could not be selected");
			return false;
		}
		
	}
	
	public boolean sendPickUpTime(String time) {
		try {
			pickUpTime.sendKeys(time);
			log.info("time entered");
			Reports.generateReport(driver, test, Status.PASS, time+" successfully entered");
			return true;
		}catch(Exception e) {
			log.error("time not selected");
			Reports.generateReport(driver, test, Status.FAIL, time+" could not be selected");
			return false;
		}
	}
	
	public boolean selectPassNo(String passengerNo) {
		try {
			noOfPassenger.click();
			Select sel = new Select(noOfPassenger);
			sel.selectByVisibleText(passengerNo);
			log.info("passenger number selected");
			Reports.generateReport(driver, test, Status.PASS, passengerNo+" successfully selected");
			return true;
		}catch(Exception e) {
			log.error("passenger number not selected");
			Reports.generateReport(driver, test, Status.FAIL, passengerNo+" could not be selected");
			return false;
		}
		
	}
	
	
	public boolean selectTripType(String type) {
		try {
			if(type.equals("One way")) {
				oneWay.click();
				log.info("One way trip type selected");
				Reports.generateReport(driver, test, Status.PASS, type+" successfully selected");
			}else if(type.equals("Round trip")) {
				roundTrip.click();
				log.info("Round way trip type selected");
				Reports.generateReport(driver, test, Status.FAIL, type+" could not be selected");
			}
			return true;
			
		}catch(Exception e) {
			log.error("trip type not selected");
			Reports.generateReport(driver, test, Status.FAIL, type+" could not be selected");
			return false;
		}
	}
	
	public boolean booknow() {
		try {
			bookNow.click();
			log.info("Booking confirmed");
			Reports.generateReport(driver, test, Status.PASS, "Book Now successfully clicked");
			return true;
			
		}catch(Exception e) {
			log.error("Booking not confirmed");
			Reports.generateReport(driver, test, Status.FAIL, "Book Now could not be clicked");
			return false;
		}
	}
	
	public boolean checkValidResult() {
		try {
			log.info("Valid result displayed");
			Reports.generateReport(driver, test, Status.PASS, "Test passed successfully");
			return checkTable.isDisplayed();
			
		}catch(Exception e) {
			log.error("Valid result not displayed");
			Reports.generateReport(driver, test, Status.FAIL, "Test failed");
			return false;
		}
	}
	
	
	public boolean checkInvalidResult() {
		try {
			if(checkTable.isDisplayed()) {
				log.error("Invalid result displayed");
				Reports.generateReport(driver, test, Status.FAIL, "Test failed");
				return false;
			}			
			
		}catch(Exception e) {
			log.info("Invalid result not displayed");
			Reports.generateReport(driver, test, Status.PASS, "Test passed successfully");
			return false;
		}
		return true;
	}
	
	public boolean checkBlankData() {
		try {
			if(checkTable.isDisplayed() == false) {
				Reports.generateReport(driver, test, Status.PASS, "Data is not displayed" );
				log.info("Data is not displayed");
				return true;
			} else {
				Reports.generateReport(driver, test, Status.FAIL, "Data is displayed" );
				log.info("Data is displayed");
				return false;
			}
		} catch(Exception e) {
			Reports.generateReport(driver, test, Status.PASS, "Enter Data message" );
			log.info("Enter Data message");
			return true;
		}
	}
	
	
	
}