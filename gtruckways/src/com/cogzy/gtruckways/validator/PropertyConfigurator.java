package com.cogzy.gtruckways.validator;

import java.util.Properties;

public class PropertyConfigurator {
	
	private static PropertyConfigurator instance = new PropertyConfigurator();
	private Properties prop = new Properties();
	
	/* Make default constructor private for Singleton Pattern implementation */
	private PropertyConfigurator() {	
		loadProp("config.properties");
	}
	
	/** A single instance of PropertyConfigurator is always returned as part of singleton pattern */
	public static PropertyConfigurator getInstance() {
		return instance;
	}
	
	private void loadProp(String propFileName) {
		try {
			java.io.InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);			
			prop.load(inputStream);		
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {		
		return prop.getProperty(key);
	}
}
