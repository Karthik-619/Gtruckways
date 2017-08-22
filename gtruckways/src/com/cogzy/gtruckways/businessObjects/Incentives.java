package com.cogzy.gtruckways.businessObjects;

public class Incentives {

	private int incentivesId;
	private int driverId;
	private String code;
	private float incAmount;
	private String dateTime;
	private String bookId;
	
	
	public int getIncentivesId() {
		return incentivesId;
	}
	public void setIncentivesId(int incentivesId) {
		this.incentivesId = incentivesId;
	}
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
	public float getIncAmount() {
		return incAmount;
	}
	public void setIncAmount(float incAmount) {
		this.incAmount = incAmount;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
}
