package com.cab.cucumber.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	
	
	
	public static Properties readProperty() {
		Properties properties = new Properties();
		String fileName = ".\\src\\test\\java\\com\\cab\\cucumber\\config\\configuration.properties";
		try {
			FileInputStream file = new FileInputStream(fileName);
			properties.load(file);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return properties;
	}
}
