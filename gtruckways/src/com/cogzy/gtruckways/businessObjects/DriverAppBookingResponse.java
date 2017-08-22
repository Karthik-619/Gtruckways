package com.cogzy.gtruckways.businessObjects;

public class DriverAppBookingResponse {

	private String bookingId;
	
	private float totalAmount;
	
	private String mobileNo;
	
	private String userName;
	
	private String userEmail;
	
	private int driverId;
	
	private String pickupLocation;
	
	private String dropLocation;
	
	private double sourceLat;
	
	private double sourceLong;
	
	private double destLat;
	
	private double destLong;
	
	private String material;

	private String statusMessage;
	
	private String driverStatus;
	
	private int statusCode;
	
	private String pickUpTime;
	
	private int helper;
	
	
	
	
	//private float approximateAmount;
	
	
	
	public int getHelper() {
		return helper;
	}

	public void setHelper(int helper) {
		this.helper = helper;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
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

	public double getSourceLat() {
		return sourceLat;
	}

	public void setSourceLat(double sourceLat) {
		this.sourceLat = sourceLat;
	}

	public double getSourceLong() {
		return sourceLong;
	}

	public void setSourceLong(double sourceLong) {
		this.sourceLong = sourceLong;
	}

	public double getDestLat() {
		return destLat;
	}

	public void setDestLat(double destLat) {
		this.destLat = destLat;
	}

	public double getDestLong() {
		return destLong;
	}

	public void setDestLong(double destLong) {
		this.destLong = destLong;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
/*
	public float getApproximateAmount() {
		return approximateAmount;
	}

	public void setApproximateAmount(float approximateAmount) {
		this.approximateAmount = approximateAmount;
	}
*/

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

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

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	
	
}
