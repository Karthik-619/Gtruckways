package com.cogzy.gtruckways.businessObjects;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Otp {

	private int otpId;
	
	private User use;
	
	private int otpNumber;
	
	private String otpSendTime;
	
	private String otpResponseTime;

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public User getUse() {
		return use;
	}

	public void setUse(User use) {
		this.use = use;
	}

	public int getOtpNumber() {
		return otpNumber;
	}

	public void setOtpNumber(int otpNumber) {
		this.otpNumber = otpNumber;
	}

	public String getOtpSendTime() {
		return otpSendTime;
	}

	public void setOtpSendTime(String otpSendTime) {
		this.otpSendTime = otpSendTime;
	}

	public String getOtpResponseTime() {
		return otpResponseTime;
	}

	public void setOtpResponseTime(String otpResponseTime) {
		this.otpResponseTime = otpResponseTime;
	}
	
	
	public int getUserOtp(){
		int otp=0;
		try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            otp= sr.nextInt(9000) + 1000;
           
        
		} catch (NoSuchAlgorithmException e) {
        } 
        System.out.println("secOtp500: "+otp);
    
		
		
		return otp;
	}
	
	
}
