package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.CustomerAppResponse;
import com.cogzy.gtruckways.valueObjects.ConfirmBookingResponse;
import com.cogzy.gtruckways.valueObjects.GenericResponse;

public interface CustomerService {

public CustomerAppResponse CustomerLogin(String mobileNo,String password);
	
	public GenericResponse customerData(String user_name, String mobileNo,String email, String fcm_token );
	
	public GenericResponse loginData(String phone_no, String fcm_token,int otp);
	
	public GenericResponse upadteUser(int user_id, String userName, String email, String phone);
	
	public GenericResponse confirmBookingData(ConfirmBookingResponse post);
	
	public GenericResponse cancelBookingData(String bookingId, String reason, String comment);
	
	public GenericResponse getOrderList(int user_id); 
	
	public GenericResponse driverId(int driver_id);
	
	public GenericResponse CheckPromoCodeExistsOrNot(String promoCode, float totalDistance, float price,String travelDate,float basePrice,int truckId,String status);
	
	
	public GenericResponse getPromocodes();
	
}
