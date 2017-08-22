package com.cogzy.gtruckways.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.CustomerPayment;
import com.cogzy.gtruckways.businessObjects.DriverDetailsResponse;
import com.cogzy.gtruckways.businessObjects.DriverTripDetailsResponse;
import com.cogzy.gtruckways.businessObjects.Invoice;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Telecaller;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.valueObjects.AddtionalPricePojo;

public interface TelePostService {

	public List<Post> getPostDetails();
	public Post getPostInformation(String PostId);
	public List<TruckInfo> getTruckInfoDetails();
	
	public CustomerPayment	getCustomerPaymentInfo(int PostId);
	public int	updatePostDetails(Post pos);
	public int	getAccountsId(int UserId);
	public int	addToAccounts(int UserId);
	public int	updateCancel(Post pos);
	public float	updateTotalAmountAfterPayment(Post pos,float totalAmount);
	
	public int addFinancialTransaction(CustomerPayment cp,int AccId);
	public int addAccountReceivable(CustomerPayment cp,int AccId, int transactionId);
	public int addPayment(CustomerPayment cp,int transactionId,int AccId,int accRecevableId);
	
	public String checkStatus(String bookingId);
	public int srcReached(Post ps);
	public int updateLoad(Post pos);
	public int destReached(Post pos);
	public int checkPayment(int Postid);
	public int updateUnload(Post pos);
	
	public Post updateAdditionalPrice(AddtionalPricePojo additionalPrice,Post pos);
	public Invoice getInvoiceDetails(int Postid);
	public List<Vehicle> getListTransporter(int truckId);
	
	public Vehicle getDriverConfirmation(String PostId);
	public boolean updateFeedback(String feedback,LocalDateTime feedbackDate,Post pos);
	
	public int driverCanceledtheTrip(String bookingId,int driverId,int penaltyAmount);

	public int NoResponseFromDriver(String bookingId,int driverId);
	
	public TripDetails getTripDetailsofBooking(String bookingId);
	
	public DriverDetailsResponse getDriverDetails(String regNo);
	
	public int updateDriverStatus(int driverId,int StatusId);
	
	public List<Post> getTripResponseOfDriver(int driverId,String fromDate,String toDate);
	
	public DriverTripDetailsResponse getIncentivesAndDeductions(int driverId,String bookingId);
	
	public DriverTripDetailsResponse addDeductions(int dedAmount, String reason,DriverDetailsResponse driverResp,String bookingId);
	
	public TripDetails getDailyKmAndMinsofVehicleRegNo(String fromDate, String toDate,String vehicleRegNo);
	
	
	public LiveTracking getBookWiseTracking(String bookingId, String srcReachedTime, String destReachedTime);
	
	public Telecaller checkTelecallerExistsorNot(String email,String password,String status);
	
	public Post getCustomerInformation(String infoId);
	
	public User addCustomersManualy(User user);
	
	public Post getManualBookingProcess(Post post);
	
	public Post insertBookingInformation(Post pos);
	
	public List<Post> getLandPageCustomers();
	
	public int landPageStatus(int customerId,String status);
	
}
