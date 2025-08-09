package com.cab.cucumber.definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.cab.cucumber.hooks.Hooks;
import com.cab.cucumber.pages.BookingPage;
import com.cab.cucumber.pages.HomePage;
import com.cab.cucumber.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Booking {
	public WebDriver driver = Hooks.driver;
	public ExtentTest test = Hooks.test;
	String[] data = new String[10];
	public BookingPage bookObj;
	
	
	public HomePage homeObj;
	
	@Given("Navigate to Booking Page")
	public void navigate_to_booking_page() {		
		 homeObj = new HomePage(driver, test);
		 Assert.assertTrue(homeObj.clickBooking());
	}

	@When("Enter all the fields with valid input for {string}")
	public void enter_all_the_fields_with_valid_input(String Rows) throws Exception {
		bookObj = new BookingPage(driver, test);
		data = ExcelReader.readData(".\\src\\test\\java\\com\\cab\\cucumber\\config\\TestData.xlsx", "Sheet1", Rows);
		Assert.assertTrue(bookObj.enterName(data[0]));
		Assert.assertTrue(bookObj.enterPhone(data[1]));
		Assert.assertTrue(bookObj.enterMail(data[2]));
		Assert.assertTrue(bookObj.clickTripType(data[3]));
		Assert.assertTrue(bookObj.selectCab(data[4]));
		Assert.assertTrue(bookObj.selectCarType(data[5]));
		Assert.assertTrue(bookObj.sendDate(data[6]));
		Assert.assertTrue(bookObj.sendPickUpTime(data[7]));
		Assert.assertTrue(bookObj.selectPassNo(data[8]));
		Assert.assertTrue(bookObj.selectTripType(data[9]));
		
	
		
	}

	@When("click the Book Now button")
	public void click_the_book_now_button() {
		Assert.assertTrue(bookObj.booknow());
	}

	@Then("verify the valid data")
	public void verify_the_data() {
		Assert.assertTrue(bookObj.checkValidResult());
	}
	
	@When("Enter all the fields with invalid input for {string}")
	public void enter_all_the_fields_with_invalid_input(String Rows) throws Exception {
		bookObj = new BookingPage(driver, test);
		data = ExcelReader.readData(".\\src\\test\\java\\com\\cab\\cucumber\\config\\TestData.xlsx", "Sheet2", Rows);
		Assert.assertTrue(bookObj.enterName(data[0]));
		Assert.assertTrue(bookObj.enterPhone(data[1]));
		Assert.assertTrue(bookObj.enterMail(data[2]));
		Assert.assertTrue(bookObj.clickTripType(data[3]));
		Assert.assertTrue(bookObj.selectCab(data[4]));
		Assert.assertTrue(bookObj.selectCarType(data[5]));
		Assert.assertTrue(bookObj.sendDate(data[6]));
		Assert.assertTrue(bookObj.sendPickUpTime(data[7]));
		Assert.assertTrue(bookObj.selectPassNo(data[8]));
		Assert.assertTrue(bookObj.selectTripType(data[9]));
	}
	

	@Then("verify the invalid data")
	public void verify_the_invalid_data() {
	   Assert.assertTrue(bookObj.checkInvalidResult());
	}
	
	
	@When("click the Book Now button with blank data")
	public void click_the_book_now_button_with_blank_data() {
	    // Write code here that turns the phrase above into concrete actions
		bookObj = new BookingPage(driver, test);
		Assert.assertTrue(bookObj.booknow());
	}

	@Then("verify blank data")
	public void verify_blank_data() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(bookObj.checkBlankData());
	   
	}
}
