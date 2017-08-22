package com.cogzy.gtruckways.businessObjects;

import java.time.LocalDate;

public class DriverWeeklySlabsResponse {

	private float tripEarnings;
	private float cashCollect;
	private float incentiveAmount;
	private float deductionAmount;
	private String fromDate;
	private String toDate;
	private String message;
	
	
	
	/*public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}*/
	
	
	
	public float getTripEarnings() {
		return tripEarnings;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
