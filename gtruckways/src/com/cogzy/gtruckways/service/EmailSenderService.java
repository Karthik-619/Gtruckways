package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;

public interface EmailSenderService {

	public String otpEmail(User use);
	
	public String postDetailsMail(String email,String mobileNo,String postDate,String bookingId, String password,String username,int UserStatus);
	 
	 
	 public String sendTransConfirmMail(Post pos,String RegNum,String Dvr_Name,String Dvr_Contact);
	 
	 
	 public int SendDriverInfoToCustomer(String bookingId,String driverName, String mobileNo, String emailId,String regNo);
	 
	 public int TripcompletionMail(String email,String bookingId,float totalAmount);
	 
	 public int mailToTelecaller(Post pos);

	public String forgotpassEmail(String Eemail,String secureSaltString);

	public String forgotpassEmailRetailUser(String Eemail,String secureSaltString);
	
	public String passSendEmail(EnterpriseCustomer ecust, String password);

	 public void sendConfirmationEmail(Post pos);

}
