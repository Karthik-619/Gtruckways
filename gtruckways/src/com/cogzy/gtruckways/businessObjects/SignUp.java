package com.cogzy.gtruckways.businessObjects;

public class SignUp {
	

	private String userName, mobileNo, email, fcmToken;
	private int appUser, userId, otp;
	
	
	
	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getUserName() {
		return userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAppUser() {
		return appUser;
	}
	public void setAppUser(int appUser) {
		this.appUser = appUser;
	}
	
	
	
	
	
	
	
	
	
	

}
