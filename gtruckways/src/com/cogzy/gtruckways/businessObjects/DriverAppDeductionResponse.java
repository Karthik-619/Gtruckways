package com.cogzy.gtruckways.businessObjects;

public class DriverAppDeductionResponse {

	
	private float amount;
	private String code;
	private String bookingId;
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

	public String getDate() {
		return Date;
	}

	private String Date;
	private float tripEarnings;
	private float cashCollect;
	private float tripFare;
	
	
	
	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDeductionDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}
	
	
	
}
