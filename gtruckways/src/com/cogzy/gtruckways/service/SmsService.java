package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.DriverAppBookingResponse;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.User;

public interface SmsService {

	
	public int getOtpSms(User use);
	public int getBookingInformationWithDriverName(LocalDriver driver, DriverAppBookingResponse bookResponse);
	
	public int confirmationSmsAfterFinish(String mobileNo,String bookingId,float totalAmount);
	
	public int getCustomerAppOTP(String mobileNo,int Otp);
	
}
