package com.cab.cucumber.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
    features = "src/test/java/com/cab/cucumber/features",
    glue = {"com.cab.cucumber.definitions", "com.cab.cucumber.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"},
    tags = "@Services or @Booking"
   
)
public class RunnerUsingTestNG extends AbstractTestNGCucumberTests {
    // No implementation needed here
}