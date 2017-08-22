package com.cogzy.gtruckways.businessObjects;

import java.sql.Blob;

public class LocalDriver {

	private int driverId;
	
	private String driverName;
	
	private String address;
	
	private String mobile;
	
	private String emailId;
	
	private Blob photo;
	
	private String dlNo;
	
	private String dlIssueDate;
	
	private String dlValidity;
	
	private String driverStatus;

	private String driverRegNo;
	
	private String password;
	
	private double curLat;
	
	private double curLong;
	
	private String distanceFromSource;
	
	private String fcmToken;
	
	private String imeiNo;
	
	
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

	public double getCurLat() {
		return curLat;
	}

	public void setCurLat(double curLat) {
		this.curLat = curLat;
	}

	public double getCurLong() {
		return curLong;
	}

	public void setCurLong(double curLong) {
		this.curLong = curLong;
	}

	public String getDistanceFromSource() {
		return distanceFromSource;
	}

	public void setDistanceFromSource(String distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}

	public String getDriverRegNo() {
		return driverRegNo;
	}

	public void setDriverRegNo(String driverRegNo) {
		this.driverRegNo = driverRegNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	public String getDlIssueDate() {
		return dlIssueDate;
	}

	public void setDlIssueDate(String dlIssueDate) {
		this.dlIssueDate = dlIssueDate;
	}

	public String getDlValidity() {
		return dlValidity;
	}

	public void setDlValidity(String dlValidity) {
		this.dlValidity = dlValidity;
	}

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}
	
	
	
}
