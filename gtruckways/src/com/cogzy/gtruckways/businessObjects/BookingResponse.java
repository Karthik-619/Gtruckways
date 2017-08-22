package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class BookingResponse {

	
	private String bookingId;
	
	private String  dateAndTime;
	
	private float tripFare;
	private float tripEarnings;
	
	private float cashCollected;
	

	
	private float sumIncentives;
	
	private float sumDeductions;
	
	
	
	private List<Object> incentives;
	
	private List<Object> deductions;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public float getTripFare() {
		return tripFare;
	}

	public void setTripFare(float tripFare) {
		this.tripFare = tripFare;
	}

	public float getTripEarnings() {
		return tripEarnings;
	}

	public void setTripEarnings(float tripEarnings) {
		this.tripEarnings = tripEarnings;
	}

	public float getSumIncentives() {
		return sumIncentives;
	}

	public void setSumIncentives(float sumIncentives) {
		this.sumIncentives = sumIncentives;
	}

	public float getSumDeductions() {
		return sumDeductions;
	}

	public void setSumDeductions(float sumDeductions) {
		this.sumDeductions = sumDeductions;
	}

	public float getCashCollected() {
		return cashCollected;
	}

	public void setCashCollected(float cashCollected) {
		this.cashCollected = cashCollected;
	}

	public List<Object> getIncentives() {
		return incentives;
	}

	public void setIncentives(List<Object> incentives) {
		this.incentives = incentives;
	}

	public List<Object> getDeductions() {
		return deductions;
	}

	public void setDeductions(List<Object> deductions) {
		this.deductions = deductions;
	}
	
	
	
	
	
}
