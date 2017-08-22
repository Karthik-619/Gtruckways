package com.cogzy.gtruckways.businessObjects;

public class Telecaller {

	
	private String userName;

	private String userType;
	
	private String telecallerName;
	
	private String password;
	
	private String telecallerEmail;
	
	private int telecallerId;
	
	private int telecallerActive;

	private int statusCode;
	
	
	
	
	public String getTelecallerName() {
		return telecallerName;
	}

	public void setTelecallerName(String telecallerName) {
		this.telecallerName = telecallerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelecallerEmail() {
		return telecallerEmail;
	}

	public void setTelecallerEmail(String telecallerEmail) {
		this.telecallerEmail = telecallerEmail;
	}

	public int getTelecallerId() {
		return telecallerId;
	}

	public void setTelecallerId(int telecallerId) {
		this.telecallerId = telecallerId;
	}

	public int getTelecallerActive() {
		return telecallerActive;
	}

	public void setTelecallerActive(int telecallerActive) {
		this.telecallerActive = telecallerActive;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
	
	
}
