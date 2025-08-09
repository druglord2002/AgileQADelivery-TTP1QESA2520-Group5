package com.cab.cucumber.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cab.cucumber.utils.Reports;

public class ServicesPage extends BasePage{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	private static final Logger log = LogManager.getLogger(ServicesPage.class);
	
	public ServicesPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	@FindBy(xpath = "//a[text() = 'Mini']") public WebElement Mini;
	@FindBy(xpath = "//a[text() = 'Micro']") public WebElement Micro;
	@FindBy(xpath = "//a[text() = 'Sedan']") public WebElement Sedan;
	@FindBy(xpath = "//a[text() = 'Suv']") public WebElement Suv;
	
	public boolean click(String type) {
		try {
			
			if(type.equals("Mini")) {
				WebElement minibtn = wait.until(ExpectedConditions.elementToBeClickable(Mini));
				log.info("Clicking Mini button");
				minibtn.click();
				Reports.generateReport(driver, test, Status.PASS, type+" link clicked successfully");
			}else if(type.equals("Micro")) {
				WebElement microbtn = wait.until(ExpectedConditions.elementToBeClickable(Micro));
				microbtn.click();
				log.info("Clicking Micro button");
				Reports.generateReport(driver, test, Status.PASS, type+" link clicked successfully");
			}else if(type.equals("Sedan")) {
				WebElement sedanbtn = wait.until(ExpectedConditions.elementToBeClickable(Sedan));
				log.info("Clicking Sedan button");
				sedanbtn.click();
				Reports.generateReport(driver, test, Status.PASS, type+" link clicked successfully");
			}else if(type.equals("SUV")) {
				WebElement suvbtn = wait.until(ExpectedConditions.elementToBeClickable(Suv));
				log.info("Clicking SUV button");
				suvbtn.click();
				Reports.generateReport(driver, test, Status.PASS, type+" link clicked successfully");
			}
			
		}catch(Exception e) {
			log.error("Link could not be clicked");
			Reports.generateReport(driver, test, Status.FAIL, type+" link could not be clicked successfully");
			return false;
		}
		
		return true;
	}
	
	
}
