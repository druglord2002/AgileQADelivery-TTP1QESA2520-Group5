package com.cab.cucumber.utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class LaunchBrowser {
	
	public static WebDriver driver;
	
	Properties properties = PropertyReader.readProperty();
	
	public void launchBrowser() {
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(properties.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("Enter only either chrome or firefox or edge");
			return;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(properties.getProperty("baseUrl"));

	}
	
/*	public static void main(String[] args) {
		LaunchBrowser lb = new LaunchBrowser();
		lb.launchBrowser();
	}*/
}