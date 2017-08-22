package com.cogzy.gtruckways.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.CustomerPayment;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.DriverDetailsResponse;
import com.cogzy.gtruckways.businessObjects.DriverTripDetailsResponse;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.Invoice;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.Telecaller;
import com.cogzy.gtruckways.businessObjects.TransConfirm;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;

public interface TelePostDao {

	public List<Post> getPostDetails();
	public Post getPostInformation(String PostId);
	public List<TruckInfo> getTruckInfoDetails();
	public CustomerPayment	getCustomerPaymentInfo(int PostId);
	public int	updatePostDetails(Post pos);
	public int	getAccountsId(int UserId);
	public int	addToAccounts(int UserId);
	public int	updateCancel(Post pos);
	public int updateCustomerPayment(Post pos);
	public int addFinancialTransaction(CustomerPayment cp,int AccId);
	public int addAccountReceivable(CustomerPayment cp,int AccId, int transactionId);
	public int addPayment(CustomerPayment cp,int transactionId,int AccId,int accRecevableId);
	public String checkStatus(String bookingId);
	public int srcReached(Post ps);
	public int updateLoad(Post pos);
	public int destReached(Post pos);
	public int checkPayment(int Postid);
	public int updateUnload(Post pos);
	public int updatePostInformationAfterTripComplete(Post pos,Price price);
	public Invoice getInvoiceDetails(int Postid);
	List<Vehicle> getListTransporter(int truckId);
	public Vehicle getDriverConfirmation(String PostId);
	public int updateFeedback(String feedback,LocalDateTime feedbackDate,Post pos);
	public TripDetails getTripDetailsofBook(String bookingId);
	public DriverDetailsResponse getDriverDetails(String vehicleRegNo);
	public List<Post> getBookingsOfDriver(int driverId, String fromDate, String toDate);
	public List<Incentives> getDriverIncentives(int driverId,String bookId);
	public List<Deductions> getDriverDeductions(int driverId,String bookId);
	public DriverTripDetailsResponse getParticularBookingDetails(int driverId,String bookingId);
	public int sumofIncetivesofBookId(int driverId,String bookingId);
	public int sumofDeductionsofBookId(int driverId,String bookingId);
	public List<TripDetails> getDailyKmAndMinsofVehicleRegNo(String fromDate, String toDate,String vehicleRegNo);
	public List<LiveTracking> getVehicleTracking(String bookingId, String srcReachedTime, String destReachedTime);
	public Telecaller checkTelecallerExistsorNot(String email, String password,String status);
	
	public Post getCustomerInformation(String infoId);
	
	public User getCustomersInformationManualy(User user);
	
	public int insertCustomerManualy(User user);
	
	public List<Post> getLandPageCustomers();
	
	public int updateLandPageStatus(int customerId,String status);
}
