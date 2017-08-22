package com.cogzy.gtruckways.businessObjects;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


import com.cogzy.gtruckways.validator.Log;

public class DriverAppTime {

	private LocalDate weekStartDate;
	
	private LocalDate weekEndDate;
	
	
	private String currentMonth;
	
	private int currentYear;

	
	
	private LocalDate todayDate;
	
	private LocalDate firstWeekStartDate;
	
	
	private LocalDate firstWeekEndDate;
	
	
	private LocalDate secondWeekStartDate;
	
	
	private LocalDate secondWeekEndDate;
	
	private LocalDate thirdWeekStartDate;
	
	private LocalDate thirdWeekEndDate;
	
	
	private LocalDate fourthWeekStartDate;
	
	private LocalDate fourthWeekEndDate;
	
	
	
	

	
	

	public LocalDate getFirstWeekStartDate() {
		return firstWeekStartDate;
	}

	public void setFirstWeekStartDate(LocalDate firstWeekStartDate) {
		this.firstWeekStartDate = firstWeekStartDate;
	}

	public LocalDate getFirstWeekEndDate() {
		return firstWeekEndDate;
	}

	public void setFirstWeekEndDate(LocalDate firstWeekEndDate) {
		this.firstWeekEndDate = firstWeekEndDate;
	}

	public LocalDate getSecondWeekStartDate() {
		return secondWeekStartDate;
	}

	public void setSecondWeekStartDate(LocalDate secondWeekStartDate) {
		this.secondWeekStartDate = secondWeekStartDate;
	}

	public LocalDate getSecondWeekEndDate() {
		return secondWeekEndDate;
	}

	public void setSecondWeekEndDate(LocalDate secondWeekEndDate) {
		this.secondWeekEndDate = secondWeekEndDate;
	}

	public LocalDate getThirdWeekStartDate() {
		return thirdWeekStartDate;
	}

	public void setThirdWeekStartDate(LocalDate thirdWeekStartDate) {
		this.thirdWeekStartDate = thirdWeekStartDate;
	}

	public LocalDate getThirdWeekEndDate() {
		return thirdWeekEndDate;
	}

	public void setThirdWeekEndDate(LocalDate thirdWeekEndDate) {
		this.thirdWeekEndDate = thirdWeekEndDate;
	}

	public LocalDate getFourthWeekStartDate() {
		return fourthWeekStartDate;
	}

	public void setFourthWeekStartDate(LocalDate fourthWeekStartDate) {
		this.fourthWeekStartDate = fourthWeekStartDate;
	}

	public LocalDate getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(LocalDate weekStartDate) {
		this.weekStartDate = weekStartDate;
	}

	public LocalDate getWeekEndDate() {
		return weekEndDate;
	}

	public void setWeekEndDate(LocalDate weekEndDate) {
		this.weekEndDate = weekEndDate;
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public LocalDate getFourthWeekEndDate() {
		return fourthWeekEndDate;
	}

	public void setFourthWeekEndDate(LocalDate fourthWeekEndDate) {
		this.fourthWeekEndDate = fourthWeekEndDate;
	}
	
	public LocalDate getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(LocalDate todayDate) {
		this.todayDate = todayDate;
	}
	
	
	
	
	
	
	public static LocalDate getCurrentDate() {
	    
	
		 LocalDate today = LocalDate.now();
		
		 Log.info("today Date is-->"+today);
		 
		 return today;
		
	
	
}


public static DriverAppTime getCurrentWeek() {
	
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
    weekdates.setWeekStartDate(monday);
    weekdates.setWeekEndDate(sunday);
    return weekdates;
}


public static DriverAppTime getCurrentMonthAndYearAndWeekSlabs() {
	
	DriverAppTime monthYearAndWeekSlabs=new DriverAppTime();
	
	String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
	        "August", "September", "October", "November", "December" };

	    Calendar cal = Calendar.getInstance();
	    String month = monthName[cal.get(Calendar.MONTH)];
	    int year=cal.get(Calendar.YEAR);
	    System.out.println("Month name: " + month);
	    System.out.println("Year name: " + year);
	    
	    monthYearAndWeekSlabs.setCurrentMonth(month);
	    monthYearAndWeekSlabs.setCurrentYear(year);		
	
	    LocalDate today = LocalDate.now();
		
		
		LocalDate ws1=today.withDayOfMonth(1);
		LocalDate we1=ws1.plusDays(6);
		LocalDate ws2=we1.plusDays(1);
		LocalDate we2=ws2.plusDays(6);
		LocalDate ws3=we2.plusDays(1);
		LocalDate we3=ws3.plusDays(6);
		LocalDate ws4=we3.plusDays(1);
		LocalDate we4=today.withDayOfMonth(today.lengthOfMonth());
		
	/*	today=today.plusDays(15);*/
		
		
		monthYearAndWeekSlabs.setFirstWeekStartDate(ws1);
		monthYearAndWeekSlabs.setFirstWeekEndDate(we1);
		monthYearAndWeekSlabs.setSecondWeekStartDate(ws2);
		monthYearAndWeekSlabs.setSecondWeekEndDate(we2);
		monthYearAndWeekSlabs.setThirdWeekStartDate(ws3);
		monthYearAndWeekSlabs.setThirdWeekEndDate(we3);
		monthYearAndWeekSlabs.setFourthWeekStartDate(ws4);
		monthYearAndWeekSlabs.setFourthWeekEndDate(we4);
		monthYearAndWeekSlabs.setTodayDate(today);
	    
	    
	    
	    
	    
	    
	
	return monthYearAndWeekSlabs;
		
	
}



	
public static  DriverAppTime getCurrentMonthWeeks(){
	DriverAppTime weekDatesofMonth =new DriverAppTime();
	
	
	LocalDate today = LocalDate.now();
	
	
	LocalDate ws1=today.withDayOfMonth(1);
	LocalDate we1=ws1.plusDays(6);
	LocalDate ws2=we1.plusDays(1);
	LocalDate we2=ws2.plusDays(6);
	LocalDate ws3=we2.plusDays(1);
	LocalDate we3=ws3.plusDays(6);
	LocalDate ws4=we3.plusDays(1);
	LocalDate we4=today.withDayOfMonth(today.lengthOfMonth());
	
	
	weekDatesofMonth.setFirstWeekStartDate(ws1);
	weekDatesofMonth.setFirstWeekEndDate(we1);
	weekDatesofMonth.setSecondWeekStartDate(ws2);
	weekDatesofMonth.setSecondWeekEndDate(we2);
	weekDatesofMonth.setThirdWeekStartDate(ws3);
	weekDatesofMonth.setThirdWeekEndDate(we3);
	weekDatesofMonth.setFourthWeekStartDate(ws4);
	weekDatesofMonth.setFourthWeekEndDate(we4);
	
	
	return weekDatesofMonth;
}






	
	
	
}
