package com.cab.cucumber.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/cab/cucumber/features",
    glue = {"com.cab.cucumber.definitions", "com.cab.cucumber.hooks"},
    plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml"},
    tags = "@Booking or @Services"
)
public class RunnerUsingJunit {
	
} 