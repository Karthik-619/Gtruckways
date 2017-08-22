package com.cogzy.gtruckways.businessObjects;

public class Deductions {

	private int deductionsId;
	private int driverId;
	private String code;
	private String reason;
	private float amount;
	private String dateTime;
	private String bookId;
	
	
	
	public int getDeductionsId() {
		return deductionsId;
	}
	public void setDeductionsId(int deductionsId) {
		this.deductionsId = deductionsId;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
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
