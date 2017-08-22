package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.DriverAppTime;

public interface TimeService {

	
	
	public String getCurrentDate();
	 
	public DriverAppTime getCurrentWeek();
	
	public  DriverAppTime getCurrentMonthAndYear();
	
}
