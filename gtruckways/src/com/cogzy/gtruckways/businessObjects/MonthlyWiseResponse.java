package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class MonthlyWiseResponse {

	
	private int statusCode;
	
	private String statusMessage;
	
	private List<WeeklyResponse> weekwise;
	
	private float totalTripEarinings;
	
	private float totalIncentives;
	
	private float totalDeductions;
	
	private float totalCashCollect;
	
	private float totaldriverAmount;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	

	

	public float getTotalTripEarinings() {
		return totalTripEarinings;
	}

	public void setTotalTripEarinings(float totalTripEarinings) {
		this.totalTripEarinings = totalTripEarinings;
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

	public float getTotalCashCollect() {
		return totalCashCollect;
	}

	public void setTotalCashCollect(float totalCashCollect) {
		this.totalCashCollect = totalCashCollect;
	}

	public float getTotaldriverAmount() {
		return totaldriverAmount;
	}

	public void setTotaldriverAmount(float totaldriverAmount) {
		this.totaldriverAmount = totaldriverAmount;
	}

	public List<WeeklyResponse> getWeekwise() {
		return weekwise;
	}

	public void setWeekwise(List<WeeklyResponse> weekwise) {
		this.weekwise = weekwise;
	}
	
	
	
}
