package com.cogzy.gtruckways.businessObjects;

public class DriverDetailsResponse {

	private int statusCode;
	
	private String statusMessage;
	
	
	


	private int driverId;
	private String driverName;
	private String mobileNo;
	
	private String fromCity;
	
	private String toCity;
	private String vehicleRegNo;
	
	private String vehicleType;
	
	private double currentLat;
	
	private double cuurentLong;
	
	private String driverStatus;
	
	private String driverStatusChangeTime;
	
	private String locationTime;
	
	private String driverType;
	
	
	private String currentLocationName;


	
	
	
	public String getFromCity() {
		return fromCity;
	}


	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}


	public String getToCity() {
		return toCity;
	}


	public void setToCity(String toCity) {
		this.toCity = toCity;
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
	
	
	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getVehicleRegNo() {
		return vehicleRegNo;
	}


	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public double getCurrentLat() {
		return currentLat;
	}


	public void setCurrentLat(double currentLat) {
		this.currentLat = currentLat;
	}


	public double getCuurentLong() {
		return cuurentLong;
	}


	public void setCuurentLong(double cuurentLong) {
		this.cuurentLong = cuurentLong;
	}


	public String getDriverStatus() {
		return driverStatus;
	}


	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}


	public String getDriverStatusChangeTime() {
		return driverStatusChangeTime;
	}


	public void setDriverStatusChangeTime(String driverStatusChangeTime) {
		this.driverStatusChangeTime = driverStatusChangeTime;
	}


	public String getLocationTime() {
		return locationTime;
	}


	public void setLocationTime(String locationTime) {
		this.locationTime = locationTime;
	}


	public String getDriverType() {
		return driverType;
	}


	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}


	public String getCurrentLocationName() {
		return currentLocationName;
	}


	public void setCurrentLocationName(String currentLocationName) {
		this.currentLocationName = currentLocationName;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	
	
	
}
