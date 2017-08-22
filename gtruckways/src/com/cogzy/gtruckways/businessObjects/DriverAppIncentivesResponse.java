package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class DriverAppIncentivesResponse {

	private String bookingId;
	private float tripFare;
	private float tripEarnings;
	private float cashCollect;
	private float incentiveAmount;
	private String incentiveCode;
	private int dryKm;
	private float deductionAmount;
	private String deductionCode;
	private int startDelayMins;
	
	 
	 
	 public int getDryKm() {
		return dryKm;
	}


	public void setDryKm(int dryKm) {
		this.dryKm = dryKm;
	}


	public int getStartDelayMins() {
		return startDelayMins;
	}


	public void setStartDelayMins(int startDelayMins) {
		this.startDelayMins = startDelayMins;
	}


	private String Date;
	private int driverId;

	

	
	
	
	
	
	
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


	public float getTripFare() {
		return tripFare;
	}


	public void setTripFare(float tripFare) {
		this.tripFare = tripFare;
	}


	private List<DriverAppIncentivesResponse> incent;


	


	



	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public List<DriverAppIncentivesResponse> getIncent() {
		return incent;
	}


	public void setIncent(List<DriverAppIncentivesResponse> incent) {
		this.incent = incent;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public float getDeductionAmount() {
		return deductionAmount;
	}


	public void setDeductionAmount(float deductionAmount) {
		this.deductionAmount = deductionAmount;
	}


	public float getIncentiveAmount() {
		return incentiveAmount;
	}


	public void setIncentiveAmount(float incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}


	public String getIncentiveCode() {
		return incentiveCode;
	}


	public void setIncentiveCode(String incentiveCode) {
		this.incentiveCode = incentiveCode;
	}


	public String getDeductionCode() {
		return deductionCode;
	}


	public void setDeductionCode(String deductionCode) {
		this.deductionCode = deductionCode;
	}
	
	
	
	
}
