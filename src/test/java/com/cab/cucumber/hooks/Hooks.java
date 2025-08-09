package com.cab.cucumber.hooks;




import org.apache.logging.log4j.core.config.Configurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cab.cucumber.utils.LaunchBrowser;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends LaunchBrowser{
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extReports;
	public static ExtentTest test;
	
	@BeforeAll()
	public static void beforeAll() {
		spark = new ExtentSparkReporter(".\\reports\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
		Configurator.initialize(null, "src\\test\\java\\com\\cab\\cucumber\\config\\log4j2.xml");
	}
	
	@Before
	public void before() {
		launchBrowser();
		test = extReports.createTest("Call Taxi Service");
	}
	
	@After()
	public void after() {
		driver.quit();		
	} 
	
	@AfterAll()
	public static void afterAll() {
		extReports.flush();
	}
}
