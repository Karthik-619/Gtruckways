package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class DriverIncentivesAndDeductions {

	
	private List<DriverAppIncentivesResponse> bookings;
	
	private List<DriverAppWeeklyResponse> daywise;
	
	//private List<DriverAppWeeklyResponse> weekwise;
	
	//private List<DriverAppDeductionResponse> deductions;
	
	private float totalTripEarnings;
	
	private float totalDriverAmount;
	
	private float totalCashCollect;
	
	private float totalIncentives;
	
	private float totalDeductions;
	
	private String message;
	
	private List<DriverWeeklySlabsResponse> weekwise;
	
	private DriverWeeklySlabsResponse weekwise1;
	

	/*public List<DriverAppDeductionResponse> getDeductions() {
		return deductions;
	}

	public void setDeductions(List<DriverAppDeductionResponse> deductions) {
		this.deductions = deductions;
	}*/
	
	
	

	

	public String getMessage() {
		return message;
	}

	public float getTotalTripEarnings() {
		return totalTripEarnings;
	}

	public void setTotalTripEarnings(float totalTripEarnings) {
		this.totalTripEarnings = totalTripEarnings;
	}

	public float getTotalDriverAmount() {
		return totalDriverAmount;
	}

	public void setTotalDriverAmount(float totalDriverAmount) {
		this.totalDriverAmount = totalDriverAmount;
	}

	public float getTotalCashCollect() {
		return totalCashCollect;
	}

	public void setTotalCashCollect(float totalCashCollect) {
		this.totalCashCollect = totalCashCollect;
	}

	public float getTotalIncentives() {
		return totalIncentives;
	}

	public void setTotalIncentives(float totalIncentives) {
		this.totalIncentives = totalIncentives;
	}

	public float getTotalDeductions() {
		return totalDeductions;
	}

	public void setTotalDeductions(float totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DriverAppIncentivesResponse> getBookings() {
		return bookings;
	}

	public void setBookings(List<DriverAppIncentivesResponse> bookings) {
		this.bookings = bookings;
	}

	public List<DriverAppWeeklyResponse> getDaywise() {
		return daywise;
	}

	public void setDaywise(List<DriverAppWeeklyResponse> daywise) {
		this.daywise = daywise;
	}

	public List<DriverWeeklySlabsResponse> getWeekwise() {
		return weekwise;
	}

	public void setWeekwise(List<DriverWeeklySlabsResponse> weekwise) {
		this.weekwise = weekwise;
	}

	public DriverWeeklySlabsResponse getWeekwise1() {
		return weekwise1;
	}

	public void setWeekwise1(DriverWeeklySlabsResponse weekwise1) {
		this.weekwise1 = weekwise1;
	}

	
	

	

	
	
	
	
}
