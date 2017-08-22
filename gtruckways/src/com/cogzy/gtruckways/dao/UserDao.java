package com.cogzy.gtruckways.dao;

import java.time.LocalDateTime;

import com.cogzy.gtruckways.businessObjects.Otp;
import com.cogzy.gtruckways.businessObjects.User;

public interface UserDao {

	public int saveUser(User u);
	
	public User fetchUserDetails(String mobileNo);
	
	public User fetchUserStatusDetails(String mobileNo,int status);
	
	public int storeOTP(User u);
	
	public int updateOTP(User u);

	public Otp getUserOTP(User u);
	
	public int updateUserStatus(String mobileNo,LocalDateTime dt);
	
	public User getUserLoginCredentials(String mobileNo,String password);
	
	public User getEmail(String lmobile);
	
	public int updateUserLoginInfo(String mobileNo,int value);
	
	public int updateUserForgotPassword(String email,String saltString);
	
	public String getEmailFromSaltString(String saltString);
	
	public int updateNewPassword(String password,String email);
	
	public int storeCustomerInformation(String formCity,String toCity,String vehicleType,String mobileNo);
	
	public int deletePotentialUser(String mobile);
	
}
