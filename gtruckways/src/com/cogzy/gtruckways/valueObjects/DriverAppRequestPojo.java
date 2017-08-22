package com.cogzy.gtruckways.valueObjects;

import java.util.ArrayList;
import java.util.List;

public class DriverAppRequestPojo {

	private String regNo;
	
	private String mobileNo;
	private String password;
	private String imeiNo;
	private String fcmToken;

	private String driverStatus;

	private double sourceLat;
	
	private double sourceLong;
	
	private double destLong;
	
	private double destLat;
	
	private String bookingId;
	
	private String appTime;
	
	private int driverId;
	
	private  String travelDate;
	
	private int status;

	private List<DriverAppRequestPojo> offlineLocations;
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public double getDestLong() {
		return destLong;
	}

	public void setDestLong(double destLong) {
		this.destLong = destLong;
	}

	public double getDestLat() {
		return destLat;
	}

	public void setDestLat(double destLat) {
		this.destLat = destLat;
	}


	

	
	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	
	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public List<DriverAppRequestPojo> getOfflineLocations() {
		return offlineLocations;
	}

	public void setOfflineLocations(List<DriverAppRequestPojo> offlineLocations) {
		this.offlineLocations = offlineLocations;
	}

	

	
	
}
