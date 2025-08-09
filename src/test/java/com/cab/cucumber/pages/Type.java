package com.cab.cucumber.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cab.cucumber.utils.Reports;

public class Type extends BasePage{
	
	@FindBy(xpath = "//h1[normalize-space() = 'Mini Cars']") WebElement miniDetails;
	@FindBy(xpath = "//h1[normalize-space()='Micro Cars']") WebElement microDetails;
	@FindBy(xpath = "//h1[normalize-space()='Sedan Cars']") WebElement sedanDetails;
	@FindBy(xpath = "//h1[normalize-space()='Suv Cars']") WebElement suvDetails;
	
	public Type(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public boolean checkDetails(String type, String details) {
		try {
			 String originalTab = driver.getWindowHandle();
			   Set<String> allTabs = driver.getWindowHandles();
			   for(String tab : allTabs) {
				   if(!tab.equals(originalTab)) {
					   driver.switchTo().window(tab);
					   break;
					     
				   }
			   }
			   
			   if(type.equals("Mini")){
				   if(details.equals(miniDetails.getText())) {
					   Reports.generateReport(driver, test, Status.PASS, type+" details verified successfully" );
					   return true;
				   }else {
					   Reports.generateReport(driver, test, Status.FAIL, type+" details could not be verified" );
					   return false;
				   }
			   }else if(type.equals("Micro")) {
				   if(details.equals(microDetails.getText())) {
					   Reports.generateReport(driver, test, Status.PASS, type+" details verified successfully" );
					   return true;
				   }else {
					   Reports.generateReport(driver, test, Status.FAIL, type+" details could not be verified" );
					   return false;
				   }
			   }else if(type.equals("Sedan")) {
				   if(details.equals(sedanDetails.getText())) {
					   Reports.generateReport(driver, test, Status.PASS, type+" details verified successfully" );
					   return true;
				   }else {
					   Reports.generateReport(driver, test, Status.FAIL, type+" details could not be verified" );
					   return false;
				   }
			   }else if(type.equals("SUV")) {
				   if(details.equals(suvDetails.getText())) {
					   Reports.generateReport(driver, test, Status.PASS, type+" details verified successfully" );
					   return true;
				   }else {
					   Reports.generateReport(driver, test, Status.FAIL, type+" details could not be verified" );
					   return false;
				   }
			   }
			
		}catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, " Element details could not be found" );
			return false;
		}
		return false;
	}
}
