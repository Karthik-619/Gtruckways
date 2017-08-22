package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class DriverAppWeeklyResponse {

	
	
	private float tripEarnings;
	private float cashCollect;
	private float incentiveAmount;
	private float deductionAmount;
	private String Date;

	private int driverId;
	
	private List<DriverAppWeeklyResponse> daywise;
	
	
	
	
	
	public List<DriverAppWeeklyResponse> getDaywise() {
		return daywise;
	}
	public void setDaywise(List<DriverAppWeeklyResponse> daywise) {
		this.daywise = daywise;
	}
	public float getTripEarnings() {
		return tripEarnings;
	}
	public void setTripEarnings(float tripEarnings) {
		this.tripEarnings = tripEarnings;
	}
	public float getCashCollect() {
		return cashCollect;
	}
	public void setCashCollect(float cashCollect) {
		this.cashCollect = cashCollect;
	}
	public float getIncentiveAmount() {
		return incentiveAmount;
	}
	public void setIncentiveAmount(float incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}
	public float getDeductionAmount() {
		return deductionAmount;
	}
	public void setDeductionAmount(float deductionAmount) {
		this.deductionAmount = deductionAmount;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	
	
	
}