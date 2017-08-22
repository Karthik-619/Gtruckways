package com.cogzy.gtruckways.dao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.BookingResponse;
import com.cogzy.gtruckways.businessObjects.DayWiseResponse;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.DriverAppLocation;
import com.cogzy.gtruckways.businessObjects.DriverAppResponse;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.MonthlyWiseResponse;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.businessObjects.VehicleLocationInfo;
import com.cogzy.gtruckways.businessObjects.WeeklyResponse;
import com.cogzy.gtruckways.businessObjects.WeeklyWiseResponse;
import com.cogzy.gtruckways.valueObjects.DriverAppRequestPojo;



public interface DriverDao {


	
	public Vehicle getDriverStatus( String mobileNo,String password);
	
	public int updateDriverStatus(String mobileNo,String password,String imeiNo,String fcmToken);
	
	
	public int assignDriverForBooking(String bookingId,int driverId,String acceptDateAndTime);
	
	public Post getBookingDetails(String bookingId,int driverId);
	
	public Post getPostDetails(String bookingId);
	
	public int cancelBooking(String bookingId,int driverId);
	
	
	public int updateTripDetailsAtPickupLocation(DriverAppRequestPojo atLocationRequest,LocalDateTime dateTime,float dryRunKm,int startDelayTime);
	
	
	public int updateBookingStatusAtLocation(DriverAppRequestPojo atLocationRequest);
	
	public int updateDriverStatustoSleepOrActive(int driverId,String status,LocalDateTime time);
	
	public int updateDeviceIdtoDriver(String mobileNo,int deviceId);
	
	public int updateBookingStatusAtStart(DriverAppRequestPojo atStart);
	
	public int updateBookingStatusAtDropLocation(DriverAppRequestPojo atDropLocation);
	
	public int updateTripDetailsAfterTripComplete(DriverAppRequestPojo end, float totalKm,int totalTime);
	
	public int updateBookingStatusAfterTripComplete(DriverAppRequestPojo end);
	
	public int updateBookingStatusTripComplete(AmountDetails amt,DriverAppRequestPojo end);
	
	public LocalDriver getDriverForPushNotifications(Post pos);
	
	public LocalDriver getFcmRegistrationToken(int driverId); 
	
	public int insertDeviceInformation(DriverAppRequestPojo alr);
	
	public int getDeviceId(DriverAppRequestPojo alr);
	
	public TripDetails getTripDetails(DriverAppRequestPojo tripComplete);
	
	public int updateVehicleLocation(double latitude,double Longitude,int driverId,String lastUpdatedTime,int status);
	
	
	public VehicleLocationInfo getVehicleLocation(int driverId);
	
	public int insertTripdetailsInAcceptOrder(int driverId,String bookingId,Route route);
	
	public TripDetails getTripDetailsInPickupLocation(String bookingId,int driverId);
	
	public int addIncentives(Incentives incent,LocalDateTime incentiveDate);
	public int addDeductions(Deductions ded,LocalDateTime deductionDate);
	
	
	public int updateBookingStatus(Post pos,int driverId);
	
	public LocalDriver getDriverDetails(int driverId);
	
	// Daily
		public DayWiseResponse getSumOfDailyTripFares(int driverId,LocalDate dateTime);
		
		public int getSumOfDailyIncentives(int driverId,LocalDate dateTime);
		
		public int getSumOfDailyDeductions(int driverId,LocalDate dateTime);
		
		public List<BookingResponse> getAllBookingsOfTheDay(int driverId,LocalDate dateTime);
		
		public int getAllIncentivesOfBooking(int driverId, LocalDate dateTime, String bookId);
		
		public int getAllDeductionsOfBooking(int driverId, LocalDate dateTime, String bookId);
		
		// weekly
		
		
		public WeeklyWiseResponse getSumOfWeeklyTripFares(LocalDate startDate, LocalDate endDate, int driverId);
		
		public int getSumOfWeeklyIncentives(LocalDate startDate, LocalDate endDate, int driverId);
		
		public int getSumOfWeeklyDeductions(LocalDate startDate, LocalDate endDate, int driverId);
		
		public List<BookingResponse> getAllBookingsOfTheWeekly(LocalDate startDate, LocalDate endDate, int driverId);
		
		public int getAllIncentivesOfDaily(String date,int driverId);
		
		public int getAllDeductionsOfDaily(String date,int driverId);
		
		
		//monthly
		
		public MonthlyWiseResponse getSumOfMonthlyTripFares(String month, int year, int driverId);
		
		public int getSumOfMonthlyIncentives(String month, int year, int driverId);
		
		public int getSumOfMonthlyDeductions(String month, int year, int driverId);
		
		public WeeklyResponse getAllWeekWiseBookingsOfTheMonthly(LocalDate startDate, LocalDate endDate, int driverId);
		
		public int UpdateBookingStatusFromCustomerApp(String status,String bookingId);
		
		public User getFcmTokenofTheUser(String bookingId);
		
		public void updateMultiplelocationDetails(List<DriverAppLocation> updateLocation);
		
		
		
		//uploading image driverId with description from driverApp 
		public int driverimageinsert(String date,int entVehDetailsId, int odometer,LocalTime time);
		public int driverimageupload(String date, EnterpriseTruckAssign assign,int odometer,LocalTime time);
		public int updateTripDetails(EnterpriseTripDetails tripinfo,int entVehDetailsId,String date1);
			public EnterpriseTruckAssign getEnterpriseInformation(int driverId);
			public int getBalanceKmofEnterprise(int enterpriseVehicleId, float noofKms);
			public EnterpriseTripDetails getTripDetails(int enterpriseVehicleId,String date);
			
			
	
}
