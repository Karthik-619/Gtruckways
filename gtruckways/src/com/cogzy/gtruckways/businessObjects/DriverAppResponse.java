package com.cogzy.gtruckways.businessObjects;

public class DriverAppResponse {

	private String driverName;
	
	private String driverStatus;
	
	private int driverId;
	
	private String statusMessage;
	
	private int statusCode;
	
	
	

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	private String username;
	
	private String mobileNo;
	
	private String pickupLocation;
	
	private String dropLocation;
	
	
	
	private String bookingId;
	
	private String totalMins;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	/*public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}*/

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	
	



	public String getTotalMins() {
		return totalMins;
	}

	public void setTotalMins(String totalMins) {
		this.totalMins = totalMins;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	
	
	
	
	
}
