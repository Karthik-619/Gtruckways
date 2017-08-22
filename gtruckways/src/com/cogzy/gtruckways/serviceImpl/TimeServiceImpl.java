/*package com.cogzy.gtruckways.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.cogzy.gtruckways.businessObjects.DriverAppTime;
import com.cogzy.gtruckways.service.TimeService;

public class TimeServiceImpl implements TimeService {

	@Override
	public String getCurrentDate() {
		    Date date = new Date();
		    String strDateFormat = "YYYY-MM-DD";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String formattedDate= dateFormat.format(date);
		    System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
		    
		    return formattedDate;
		
	}

	@Override
	public DriverAppTime getCurrentWeek() {
		
		DriverAppTime weekdates=new DriverAppTime();
		LocalDate today = LocalDate.now();

	    // Go backward to get Monday
	    LocalDate monday = today;
	    
	    
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }

	    // Go forward to get Sunday
	    LocalDate sunday = today;
	    
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }

	    System.out.println("Today: " + today);
	    System.out.println("Monday of the Week: " + monday);
	    System.out.println("Sunday of the Week: " + sunday);
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
	    String startDate = monday.format(formatter);
	    String endDate=sunday.format(formatter);
	    System.out.println("Monday of the Week: " + startDate);
	    System.out.println("Sunday of the Week: " + endDate);
	    weekdates.setWeekStartDate(startDate);
	    weekdates.setWeekEndDate(endDate);
	    return weekdates;
	}

	@Override
	public DriverAppTime getCurrentMonthAndYear() {
		
		DriverAppTime monthyear=new DriverAppTime();
		
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
		        "August", "September", "October", "November", "December" };

		    Calendar cal = Calendar.getInstance();
		    String month = monthName[cal.get(Calendar.MONTH)];
		    int year=cal.get(Calendar.YEAR);
		    System.out.println("Month name: " + month);
		    System.out.println("Year name: " + year);
		    
		    monthyear.setCurrentMonth(month);
		    monthyear.setCurrentYear(year);		
		
		
		return monthyear;
		
		
		
		
		
		
		
		
	}

	

	
	
}
*/