package com.cogzy.gtruckways.businessObjects;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class User {

	private int userId;
	private String userName;
	private String mobileNo;
	private String email;
	private String password;
	private String userType; 
	private int userStatus;
	private String fcmToken;
	private int appUser;
	boolean active;
	private Otp otp;
	private int loginStatusCode;
	private String registerDate;
	private String gstNumber;
	private int statusCode;
	
	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public int getAppUser() {
		return appUser;
	}

	public void setAppUser(int appUser) {
		this.appUser = appUser;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
	
	
	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}





	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 8;
	
	public String getUserpassword(){
	
		StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();

	}
				
	private int getRandomNumber() {
	int randomInt = 0;
	Random randomGenerator = new Random();
	randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	if (randomInt - 1 == -1) {
	return randomInt;
	} else {
	  return randomInt-1;
	}
	}
	
	
	public Otp getOtp() {
		return otp;
	}
	public void setOtp(Otp otp) {
		this.otp = otp;
	}

	public int getUserOtp(){
		int otp=0;
		try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            otp= sr.nextInt(900000) + 100000;
           
        
		} catch (NoSuchAlgorithmException e) {
        } 
        System.out.println("secOtp500: "+otp);
    
		
		
		return otp;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getLoginStatusCode() {
		return loginStatusCode;
	}

	public void setLoginStatusCode(int loginStatusCode) {
		this.loginStatusCode = loginStatusCode;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
}
