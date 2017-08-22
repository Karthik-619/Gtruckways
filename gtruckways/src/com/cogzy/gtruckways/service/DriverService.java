package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.DriverAppResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppTripdetailsResponse;
import com.cogzy.gtruckways.businessObjects.FcmResponse;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.MonthlyWiseResponse;

import java.text.ParseException;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.DayWiseResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppBookingResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppLocation;
import com.cogzy.gtruckways.businessObjects.DriverAppLoginResponse;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.WeeklyWiseResponse;
import com.cogzy.gtruckways.valueObjects.DriverAppRequestPojo;



public interface DriverService {

	
	//uploading image driverId with description from driverApp 
		public DriverAppResponse imageuploadform(String date,int driverId,String status,int odometer);
	
	
	public DriverAppLoginResponse driverLogin(DriverAppRequestPojo logininfo);
	
	public DriverAppBookingResponse acceptBookingDetails(String bookingId,int driverId,String pickupTime);
	
	public DriverAppResponse boookingCanceled(String bookingId,int driverId);
	
	
	public DriverAppResponse onPickupLocation(DriverAppRequestPojo atLocationRequest) throws ParseException;
	
	public DriverAppResponse atTripStart(DriverAppRequestPojo tripStart);
	
	public DriverAppResponse onDropLocation(DriverAppRequestPojo atdrop);
	
	public DriverAppTripdetailsResponse atTripCompelete(DriverAppRequestPojo tripComplete);
	
	public DriverAppLoginResponse updateDriverStatus(int driverId,String driverStatus);
	
	public LocalDriver getDriverForPushNotification(Post pos);
	
	public DriverAppResponse locationDetails(DriverAppRequestPojo updateLocation);
	
	public DriverAppResponse updateMultiplelocationDetails(List<DriverAppLocation> updateLocation,String driverId);
	
	public DriverAppResponse finishTrip(int driverId,String bookingId);
	
	public DriverAppResponse logoutUser(int driverId);
	
	public LocalDriver getDriverInformation(int driverId,String bookingId);
	
	public Post getUserMobileAndBookInfoForSMS(String bookingId,int driverId);
	
	public DayWiseResponse getDailyIncentives(int driverId);
	
	public WeeklyWiseResponse getWeeklyIncentives(int driverId);
	
	public MonthlyWiseResponse getMonthlyIncentives(int driverId);
	
	public FcmResponse updateBookingSatatus(Post bookinfo);
	
	
}
