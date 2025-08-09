package com.cab.cucumber.definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.cab.cucumber.hooks.Hooks;
import com.cab.cucumber.pages.HomePage;
import com.cab.cucumber.pages.ServicesPage;
import com.cab.cucumber.pages.Type;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Services {
	
	public WebDriver driver = Hooks.driver;
	public ExtentTest test = Hooks.test;
	
	public HomePage homeObj;
	public ServicesPage serviceObj;
	
	public Type typeObj;
	
	@Given("Navigate to Services Page")
	public void navigate_to_services_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //driver.findElement(By.xpath("//a[text() = 'Services']")).click();
		
		 homeObj = new HomePage(driver, test);
		 Assert.assertTrue(homeObj.clickService());
		 
	}

	@When("I click the {string} cab service link")
	public void i_click_the_mini_cab_service_link(String type) {
	    // Write code here that turns the phrase above into concrete actions
	   //driver.findElement(By.xpath("//*[text() = 'Mini']")).click();
		serviceObj = new ServicesPage(driver, test);
		serviceObj.click(type);
	}

	@Then("verify the car image and details for the {string} which contains the {string}")
	public void verify_the_car_image_and_details_for_the_mini(String type, String details) {
	    // Write code here that turns the phrase above into concrete actions
	  typeObj = new Type(driver, test);
	  Assert.assertTrue(typeObj.checkDetails(type, details));
	}
	


}
