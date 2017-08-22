package com.cogzy.gtruckways.businessObjects;



public class WeeklyResponse {

	private float tripEarinings;
	
	private float incentives;
	
	private float deductions;
	
	private float cashCollect;
	
	private String fromDate;
	
	private String toDate;

	public float getTripEarinings() {
		return tripEarinings;
	}

	public void setTripEarinings(float tripEarinings) {
		this.tripEarinings = tripEarinings;
	}

	public float getIncentives() {
		return incentives;
	}

	public void setIncentives(float incentives) {
		this.incentives = incentives;
	}

	public float getDeductions() {
		return deductions;
	}

	public void setDeductions(float deductions) {
		this.deductions = deductions;
	}

	public float getCashCollect() {
		return cashCollect;
	}

	public void setCashCollect(float cashCollect) {
		this.cashCollect = cashCollect;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

		
}
