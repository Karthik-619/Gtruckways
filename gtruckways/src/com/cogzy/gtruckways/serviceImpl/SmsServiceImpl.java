package com.cogzy.gtruckways.serviceImpl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;

import com.cogzy.gtruckways.businessObjects.DriverAppBookingResponse;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.SmsInformation;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.service.SmsService;
import com.cogzy.gtruckways.validator.Log;

public class SmsServiceImpl implements SmsService {

	private static String baseSMSUrl = "http://enterprise.smslounge.in/api/v4/?api_key=A3fcc3f5b26be13a9d16c5a3b4ff08344";
	
	public static void main(String[] args) {
		
		}

	@Override
	public int getOtpSms(User use) {
		try {
				//password
			String send = "CZYGTR";   // Sender Name
			String dest =  use.getMobileNo();
			int otp=use.getOtp().getOtpNumber();				// Receiver mobileNo
			
			String msg= "OTP%20to%20confirm%20your%20booking%20with%20gTRuckways%20is%20"+otp+"%20.";
			
			String requestUrl  = baseSMSUrl+
			 "&method="+"sms"+
			 "&sender=" + send +
			 "&to=" + dest +
			 "&message="+msg;
		
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			System.out.println("URL is-->"+url);
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return 1;
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
			}
			
	}
		
	

	@Override
	public int getBookingInformationWithDriverName(LocalDriver driver, DriverAppBookingResponse bookResponse) {
		try {
			String uname ="cogzy";		//username
			String pass = "e!5Ge!1P";		//password
			String send = "CZYGTR";   // Sender Name
			String dest =  bookResponse.getMobileNo();
			LocalDateTime date=LocalDateTime.now().withNano(0);			
			Log.info("SMS Sent Time When Driver Confirm-->"+date);
			String msg= "Your%20booking%20"+URLEncoder.encode(bookResponse.getBookingId(), "UTF-8")+"%20is%20confirmed%20on%20"+date+".%20Driver%20Name%20:%20"+URLEncoder.encode(driver.getDriverName(),"UTF-8")+"%20,%20Mobile%20:%20"+URLEncoder.encode(driver.getMobile(),"UTF-8")+"%20and%20Vehicle%20No%20:%20"+URLEncoder.encode(driver.getDriverRegNo(), "UTF-8")+".%20Thank%20you%20for%20using%20gTruckways";
			
			String requestUrl  = "http://sms.indiansmsgateway.in/SendSMS/sendmsg.php?"+
			 "uname=" + uname +
			 "&pass=" +pass+
			 "&send=" + send +
			 "&dest=" + dest +
			 "&msg="+msg;
			 //"&concat=1";
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			System.out.println("URL is-->"+url);
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return 1;
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
			}
			
	}
		
	

	public int sendBookingInformationToDriver(DriverAppBookingResponse bookResponse,LocalDriver driver) {
		try {
			String uname ="cogzy";		//username
			String pass = "e!5Ge!1P";	//password
			String send = "CZYGTR";   // Sender Name
			String dest =  driver.getMobile();
		
			String msg= "Customer Details:%20"+URLEncoder.encode(bookResponse.getUserName(),"UTF-8")+"%20,%20"+URLEncoder.encode(bookResponse.getMobileNo(),"UTF-8")+"%20,%20"+URLEncoder.encode(bookResponse.getPickupLocation(),"UTF-8")+"%20,%20"+URLEncoder.encode(bookResponse.getDropLocation(),"UTF-8")+"%20";
			
			String requestUrl  = "http://sms.indiansmsgateway.in/SendSMS/sendmsg.php?"+
			 "uname=" + uname +
			 "&pass=" +pass+
			 "&send=" + send +
			 "&dest=" + dest +
			 "&msg="+msg;
			 //"&concat=1";
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			System.out.println("URL is-->"+url);
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return 1;
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
			}
			
	}
	
	
	
	
	
	
	@Override
	public int confirmationSmsAfterFinish(String mobileNo,String bookingId,float totalAmount) {
		
		try{
		String uname ="cogzy";		//username
		String pass = "e!5Ge!1P";		//password
		String send = "CZYGTR";   // Sender Name
		String dest = mobileNo;
						// Receiver mobileNo
		String msg= "Your%20booking%20id%20"+URLEncoder.encode(bookingId,"UTF-8")+"%20has%20been%20delivered.%20The%20total%20amount%20to%20be%20paid%20is%20Rs%20"+totalAmount+".%20";
		
		String requestUrl  = "http://sms.indiansmsgateway.in/SendSMS/sendmsg.php?"+
		 "uname=" + uname +
		 "&pass=" +pass+
		 "&send=" + send +
		 "&dest=" + dest +
		 "&msg="+msg;
		 //"&concat=1";
		URL url = new URL(requestUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		System.out.println("URL is-->"+url);
		System.out.println(conn.getResponseCode());
		conn.disconnect();
		return 1;
		} catch(Exception ex) {
		System.out.println(ex.getMessage());
		return 0;
		}
		
		
		
		
		
}

	@Override
	public int getCustomerAppOTP(String mobileNo, int Otp) {
		try{
			String send = "CZYGTR";   // Sender Name
			String dest = mobileNo;
			int otp=Otp;				// Receiver mobileNo
			
			String msg= "OTP%20to%20confirm%20your%20booking%20with%20gTRuckways%20is%20"+otp+"%20.";
			
			String requestUrl  = baseSMSUrl+
			 "&method="+"sms"+
			 "&sender=" + send +
			 "&to=" + dest +
			 "&message="+msg;
		
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			System.out.println("URL is-->"+url);
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return 1;
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
			}
			
		

	
	}
	
	public int sendSmsToDriverPasswordAndUserNameAfterRegistration(String mobileNo,String password,String driverName){
		
		try{
			String uname ="cogzy";		//username
			String pass = "e!5Ge!1P";		//password
			String send = "CZYGTR";   // Sender Name
			String dest =  mobileNo;
						// Receiver mobileNo
			String msg= "Dear%20"+URLEncoder.encode(driverName,"UTF-8")+"%20,%20Your%20login%20ID%20"+URLEncoder.encode(mobileNo,"UTF-8")+"%20and%20password%20"+URLEncoder.encode(password,"UTF-8")+"%20to%20login%20with%20gTruckways%20driver%20App%20";
			
			String requestUrl  = "http://sms.indiansmsgateway.in/SendSMS/sendmsg.php?"+
			 "uname=" + uname +
			 "&pass=" +pass+
			 "&send=" + send +
			 "&dest=" + dest +
			 "&msg="+msg;
			 //"&concat=1";
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			System.out.println("URL is-->"+url);
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return 1;
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
			}
	}
	
	
	public int SendDriverInformationManuallyToCustomer(SmsInformation smsinfo) {
		try {
			String uname ="cogzy";		//username
			String pass = "e!5Ge!1P";		//password
			String send = "CZYGTR";   // Sender Name
			String dest =  smsinfo.getSendTo();
			LocalDateTime date=LocalDateTime.now().withNano(0);			
			Log.info("SMS Sent Time When Driver Confirm-->"+date);
			String msg= "Your%20booking%20"+URLEncoder.encode(smsinfo.getBookingId(),"UTF-8")+"%20is%20confirmed%20on%20"+date+".%20Driver%20Name%20:%20"+URLEncoder.encode(smsinfo.getDriverName(),"UTF-8")+"%20,%20Mobile%20:%20"+URLEncoder.encode(smsinfo.getDriverMobileNo(),"UTF-8")+"%20and%20Vehicle%20No%20:%20"+URLEncoder.encode(smsinfo.getVehicleRegNo(),"UTF-8")+".%20Thank%20you%20for%20using%20gTruckways";
			
			String requestUrl  = "http://sms.indiansmsgateway.in/SendSMS/sendmsg.php?"+
			 "uname=" + uname +
			 "&pass=" +pass+
			 "&send=" + send +
			 "&dest=" + dest +
			 "&msg="+msg;
			 //"&concat=1";
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			System.out.println("URL is-->"+url);
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return 1;
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
			}
			
	}
	
	
	
	public int sendCustomerInformationToDriver(SmsInformation smsinfo) {
		try {
			String uname ="cogzy";		//username
			String pass = "e!5Ge!1P";	//password
			String send = "CZYGTR";   // Sender Name
			String dest =  smsinfo.getSendTo();;
		
			String msg= "Customer%20Details%20:%20"+URLEncoder.encode(smsinfo.getCustomerName(),"UTF-8")+"%20,%20"+URLEncoder.encode(smsinfo.getCustomerMobileNo(),"UTF-8")+"%20,%20"+URLEncoder.encode(smsinfo.getPickUpTime(),"UTF-8")+"%20,%20"+URLEncoder.encode(smsinfo.getPickUpLocation(),"UTF-8")+"%20,%20"+URLEncoder.encode(smsinfo.getDropLocation(),"UTF-8")+"%20";
			
			String requestUrl  = "http://sms.indiansmsgateway.in/SendSMS/sendmsg.php?"+
			 "uname=" + uname +
			 "&pass=" +pass+
			 "&send=" + send +
			 "&dest=" + dest +
			 "&msg="+msg;
			 //"&concat=1";
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			System.out.println("URL is-->"+url);
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return 1;
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return 0;
			}
			
	}
	
	
	
	
	
	
	
}
