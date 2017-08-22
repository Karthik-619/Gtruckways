package com.cogzy.gtruckways.dao;



import java.util.List;

import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.SignUp;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.valueObjects.ConfirmBookingResponse;



public interface CustomerAppDao {

	
	public User getCustomerDetails(String mobile,String password);
	
	public int getCustomerData (String userName, String email, String phone_no, String fcm_token );
	
	public SignUp ifDataExist(String phone, String email );
	
	public SignUp getUserData(String phone);
	
	public int updateFcmToken(String phone_no,String fcmToken);
	
	public int getUserProfile(int userId, String userName, String email, String phone_no);
	
	public int getConfirmBooking(ConfirmBookingResponse post);
	
	public ConfirmBookingResponse getBookingDetails(String booking_id);

	public int getBookingId(String booking_id, String reason, String comment);
	
	public List<ConfirmBookingResponse> getOrderList(int user_id);
	
	public LocalDriver getDriverId(int driverId);
	
	public List<PromoCode> getPromocodes();
	
}
