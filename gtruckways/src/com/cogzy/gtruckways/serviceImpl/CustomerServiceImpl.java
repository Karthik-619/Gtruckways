package com.cogzy.gtruckways.serviceImpl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.cogzy.gtruckways.businessObjects.CustomerAppResponse;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.SignUp;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.daoImpl.CustomerAppDaoImpl;
import com.cogzy.gtruckways.daoImpl.GetPriceDaoImpl;
import com.cogzy.gtruckways.daoImpl.PostDaoImpl;
import com.cogzy.gtruckways.daoImpl.TelePostDaoImpl;
import com.cogzy.gtruckways.service.CustomerService;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.ConfirmBookingResponse;
import com.cogzy.gtruckways.valueObjects.GenericResponse;

@Configuration
@PropertySource(value="/price.properties",ignoreResourceNotFound=true)
public class CustomerServiceImpl implements CustomerService {

	CustomerAppDaoImpl customerdao;

	@Autowired
	PostDaoImpl pdao;
	
	@Autowired
	TelePostDaoImpl tdao;
	
	@Autowired
	GetPriceDaoImpl dao;
	
	 @Autowired
	 private Environment env;
	
	public CustomerAppDaoImpl getCustomerdao() {
		return customerdao;
	}

	public void setCustomerdao(CustomerAppDaoImpl customerdao) {
		this.customerdao = customerdao;
	}

	
	
	public PostDaoImpl getPdao() {
		return pdao;
	}

	public void setPdao(PostDaoImpl pdao) {
		this.pdao = pdao;
	}

	
	@Override
	public CustomerAppResponse CustomerLogin(String mobileNo, String password) {

		CustomerAppResponse cus = new CustomerAppResponse();

		User user = customerdao.getCustomerDetails(mobileNo, password);

		if (user.isActive()) {

			cus.setUserId(user.getUserId());
			cus.setUserName(user.getUserName());
			cus.setMessage("Login Successfull");
			return cus;
		} else {
			cus.setMessage("Login Unsuccessfull");
			return cus;
		}

	}

	@Override
	public GenericResponse customerData(String userName, String mobileNo, String email, String fcmToken) {

		GenericResponse res = new GenericResponse();
		
		
		SignUp signUp = customerdao.ifDataExist(mobileNo, email);
		
		System.out.println("signUp object ------->>>"+userName);
		System.out.println("phone number 1 ------->>>"+mobileNo);
		System.out.println("email ID 1 ------->>>"+email);
		
		if(signUp==null)
		{
			
			int obj = customerdao.getCustomerData(userName, mobileNo, email, fcmToken);
			if(obj==1)
			{
				
				/*res.setStatus_code("200");
				res.setStatus_message("success");
				return res;*/
				
				SignUp getDetails = customerdao.getUserData(mobileNo);
				if(getDetails==null)
				{
					res.setStatus_code("404");
					res.setStatus_message("request failed");
					return res;
				}
				else
				{
					res.setStatus_code("200");
					res.setStatus_message("success");
					res.setResponse(getDetails);
					return res;
					
				}
				
			}
			else
			{
				res.setStatus_code("404");
				res.setStatus_message("request failed");
				return res;
			}
		}
		else 
		{
			
			if(signUp.getMobileNo().equals(mobileNo))
			{
				System.out.println("if Mobile No is already exist------->>>");
				res.setStatus_code("404");
				res.setStatus_message("Mobile No is already exist");
				return res;
			}			
			else if(!signUp.getEmail().isEmpty())		
			{
				
					System.out.println("if Email id is already exist ------->>>");
					res.setStatus_code("404");
					res.setStatus_message("Email id is already exist");
					return res;
			}
			
			
			
		}
		return null;
	
		
		
	}

	
	
	@Override
	public GenericResponse loginData(String phone_no, String fcmToken,int otp) {
		
		GenericResponse res = new GenericResponse();
		
		SignUp getDetails = customerdao.getUserData(phone_no);
		
		if(getDetails==null)
		{
			res.setStatus_code("404");
			res.setStatus_message("You have not Registered!");
			return res;
		}
		else
		{
			
			int obj = customerdao.updateFcmToken(phone_no, fcmToken);
			int success=customerdao.storeOTP(phone_no,getDetails.getEmail(), otp, getDetails.getUserId());		
			
			if(obj==1)
			{
				res.setStatus_code("200");
				res.setStatus_message("success");
				res.setResponse(getDetails);
				return res;
			}
			else
			{
				res.setStatus_code("404");
				res.setStatus_message("Please try Again!");
				return res;
			}
			
			
		}
		
	}

	
	@Override
	public GenericResponse upadteUser(int user_id, String user_name, String email, String phoneNo) {

		GenericResponse res = new GenericResponse();
		
		int obj = customerdao.getUserProfile(user_id, user_name, email,phoneNo );
		if(obj==1)
		{
			
		
			SignUp getDetails = customerdao.getUserData(phoneNo);
			
			if(getDetails==null)
			{
				res.setStatus_code("404");
				res.setStatus_message("Can't fetch user details");
				return res;
			}
			else
			{
				res.setStatus_code("200");
				res.setStatus_message("profile updated");
				res.setResponse(getDetails);
				return res;
				
			}
		}
		else
		{
			res.setStatus_code("404");
			res.setStatus_message("request failed");
			return res;
		}
		//SignUp getDetails = customerdao.getUserData(phone_no);
		
		
		//return null;
	}

	@Override
	public GenericResponse confirmBookingData(ConfirmBookingResponse data) {
		
		
		GenericResponse res = new GenericResponse();
		int pid=pdao.getrandompostid();
		System.out.println("pid---------->>>>"+pid);
		String postId="GTR"+pid;
		data.setPostId(pid);
		data.setRefPostId(postId);
		data.setStatus("Booking Accepted");
		
		/*if(data.getBookingStatus()==1){
		
			data.setStatus("Customer Confirmed");
		
		} else{
			
			data.setStatus("Booking Accepted");
		}*/
		
		int obj = customerdao.getConfirmBooking(data);
		if(obj ==1)
		{
			//int obj2 = tdao.addToAccounts(data.getUserId());
			
			ConfirmBookingResponse getDetails = customerdao.getBookingDetails(data.getRefPostId());
			
			if(getDetails==null)
			{
				res.setStatus_code("404");
				res.setStatus_message("Can't fetch booking details");
				return res;
			}
			else
			{
				res.setStatus_code("200");
				res.setStatus_message("Booking Confirm");
				res.setResponse(getDetails);
				return res;
				
			}
			
			/*if(obj2==1)
			{
				ConfirmBookingResponse getDetails = customerdao.getBookingDetails(data.getRefPostId());
				
				if(getDetails==null)
				{
					res.setStatus_code("404");
					res.setStatus_message("Can't fetch booking details");
					return res;
				}
				else
				{
					res.setStatus_code("200");
					res.setStatus_message("Booking Confirm");
					res.setResponse(getDetails);
					return res;
					
				}
			}*/
			
			
		}
		else
		{
			res.setStatus_code("404");
			res.setStatus_message("Request failed");
			return res;
		}
		
	}

	@Override
	public GenericResponse cancelBookingData(String bookingId, String reason, String comment) {

		GenericResponse res = new GenericResponse();
		int obj = customerdao.getBookingId(bookingId, reason, comment);
				if(obj==1)
				{
					ConfirmBookingResponse getDetails = customerdao.getBookingDetails(bookingId);
					if(getDetails==null)
					{
						res.setStatus_code("404");
						res.setStatus_message("Can't fetch booking details");
						return res;
					}
					else
					{
						res.setStatus_code("200");
						res.setStatus_message("booking cancelled");
						res.setResponse(getDetails);
						return res;
						
					}
				}
				else
				{
					res.setStatus_code("404");
					res.setStatus_message("Request failed");
					return res;
				}
	}

	
	@Override
	public GenericResponse getOrderList(int user_id) {
		GenericResponse res = new GenericResponse();
		
		List<ConfirmBookingResponse> getOrderList = customerdao.getOrderList(user_id);
		
		if(getOrderList==null)
		{
			res.setStatus_code("404");
			res.setStatus_message("Can't get orders list");
			return res;
		}
		else
		{
			
			res.setStatus_code("200");
			res.setStatus_message("success");
			res.setResponse(getOrderList);
			return res;
		}
		
	}

	@Override
	public GenericResponse driverId(int driver_id) {
		GenericResponse res = new GenericResponse();
		LocalDriver obj = customerdao.getDriverId(driver_id);
		if(obj==null)
		{
			res.setStatus_code("404");
			res.setStatus_message("Can't get driver details");
			return res;
		}
		else
		{
			res.setStatus_code("200");
			res.setStatus_message("success");
			res.setResponse(obj);
			return res;
		}
	}

	@Override
	public GenericResponse CheckPromoCodeExistsOrNot(String promoCode, float totalDistance, float price,String travelDate,float basePrice,int truckId,String status) {
		// TODO Auto-generated method stub
		GenericResponse res = new GenericResponse();
		
		PromoCode promo=dao.CheckPromoCodeExistsOrNot(promoCode);
		
		int PromoCodeDistance=Integer.parseInt(env.getRequiredProperty("PromoCode.Distance"));
		Log.info("Promodistance-->"+PromoCodeDistance+"-->Status-->"+status);
		if(promo.isPromoActive()){
		
			 int leanHour=0;
			 int dayvalue=0;
			 
		if(status.equals("1")){
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(travelDate, formatter);
			
			
			Log.info("TravelDate-->"+dateTime);
			
			DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
			dayvalue=dayOfWeek.getValue();
			 leanHour= dateTime.getHour();
		
		}else{
			
			
			DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
			   leanHour= LocalDateTime.now().getHour();
			   dayvalue=dayOfWeek.getValue();
			
		}
			 
			 
			
			Log.info("Day Name is-->"+dayvalue+"hour-->"+leanHour);
			
		boolean percent=containsDigit(promoCode);
	
		if(percent==true){
			
			Log.info("Promocode is Discount Percent");
			
			
			if(totalDistance>=PromoCodeDistance && dayvalue>=1 && dayvalue<=4){
			
						float discountAmount=(basePrice*promo.getDiscountPercent())/100;
						float amount=price-discountAmount;
						promo.setDiscountAmount(discountAmount);
						promo.setTotalAmount(amount);
						res.setStatus_code("200");
						res.setStatus_message("success");
						res.setResponse(promo);
						return res;
				}
		
			
					promo.setTotalAmount(price);
					promo.setStatusCode(404);
					promo.setDiscountAmount(0);
					res.setStatus_code("404");
					res.setStatus_message("Invalid Promo Code");
					return res;
		
		
		}  else {
		
			if(truckId==1){
					
			  int leanDay=Integer.parseInt(env.getRequiredProperty("TataAce.LeanDay").trim());
			  int leanDayBasePrice=Integer.parseInt(env.getRequiredProperty("TataAce.LeanDay.BasePrice").trim());
			  int leanDayBaseHourPrice=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHour.BasePrice").trim());
			  Log.info("Promocode is Lean Day and Lean Hour1");	
			  int leanDayHourDay1=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHour.Day1").trim());
			  Log.info("Promocode is Lean Day and Lean Hour111");
			  int leanDayHourDay2=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHour.Day2").trim());
			 
			  Log.info("Promocode is Lean Day and Lean Hour2");
			  int leanDayHourFrom1=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.f1").trim());
			  int leanDayHourTo1=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.t1").trim());
			 
			  int leanDayHourFrom2=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.f2").trim());
			  int leanDayHourTo2=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.t2").trim());	
			  float discountAmount=0;
			
			  Log.info("Promocode is Lean Day and Lean Hour3");	
			// Lean Day Promocode Functionality
			
			if(promoCode.equalsIgnoreCase(env.getRequiredProperty("Lean.Day.PromoCode").trim())){
						
				Log.info("Promocode is Lean Day");	 
						   
						 if(leanDay==dayvalue && leanDay!=0 ){
							  
							discountAmount=promo.getDiscountPercent();
						 
							float amount=price-discountAmount;
							promo.setDiscountAmount(discountAmount);
							promo.setTotalAmount(amount);
							res.setStatus_code("200");
							res.setStatus_message("success");
							res.setResponse(promo);
							return res;
						 
						 
						 }
						
					
					
						 	promo.setTotalAmount(price);
							promo.setStatusCode(404);
							promo.setDiscountAmount(0);
							res.setStatus_code("404");
							res.setStatus_message("Invalid Promo Code");
							return res;
				// Lean Hours Promocode Functionality
			}else if(promoCode.equalsIgnoreCase(env.getRequiredProperty("Lean.Hours.PromoCode").trim())){	
			
				Log.info("Promocode is Lean hour");
				 if(dayvalue>=leanDayHourDay1 && dayvalue<=leanDayHourDay2){
					 
				  if(((leanHour>=leanDayHourFrom1 && leanHour<leanDayHourTo1) || (leanHour>=leanDayHourFrom2 && leanHour<leanDayHourTo2)) && (leanDayHourFrom1!=0 || leanDayHourTo1!=0) && (leanDayHourFrom2!=0 || leanDayHourTo2!=0)  ){
					Log.info("promocode lean hour-->"+leanHour+"dsfdj-->"+leanDayHourTo2);  
					discountAmount=promo.getDiscountPercent();
				  	
				 
			
				  float amount=price-discountAmount;
					promo.setDiscountAmount(discountAmount);
					promo.setTotalAmount(amount);
					res.setStatus_code("200");
					res.setStatus_message("success");
					res.setResponse(promo);
					return res;
				  
				  	}
				 }
			
			

				 	promo.setTotalAmount(price);
					promo.setStatusCode(404);
					promo.setDiscountAmount(0);
					res.setStatus_code("404");
					res.setStatus_message("Invalid Promo Code");
					
					return res;
				 
				 
			
			
			} else  {
					
				Log.info("Other Promocode");
				float amount=price-promo.getDiscountPercent();
				promo.setDiscountAmount(promo.getDiscountPercent());
				promo.setTotalAmount(amount);
				res.setStatus_code("200");
				res.setStatus_message("success");
				res.setResponse(promo);
				return res;
		
				}	
			
		}else{
			
			promo.setTotalAmount(price);
			promo.setStatusCode(404);
			promo.setDiscountAmount(0);
			res.setStatus_code("404");
			res.setStatus_message("Invalid Promo Code");
			
			return res;
			
		}
			
		}
		
			
			
			
		
		}	else{
			
			promo.setTotalAmount(price);
			promo.setStatusCode(404);
			promo.setDiscountAmount(0);
			res.setStatus_code("404");
			res.setStatus_message("Invalid Promo Code");
			
			return res;
		}
		
		
	}	
		
		
		
		/*if(promo.isPromoActive() && totalDistance>=15)
		{
			GetPriceServiceImpl obj = new GetPriceServiceImpl();
			//obj.containsDigit(promoCode);
			
			if(obj.containsDigit(promoCode))
			{
				float discountAmount=(price*promo.getDiscountPercent())/100;
				float amount=price-discountAmount;
				promo.setDiscountAmount(discountAmount);
				promo.setTotalAmount(amount);
				
				res.setStatus_code("200");
				res.setStatus_message("success");
				res.setResponse(promo);
				return res;
			}
			else
			{
				float amount=price-promo.getDiscountPercent();
				promo.setDiscountAmount(promo.getDiscountPercent());
				promo.setTotalAmount(amount);
				
				res.setStatus_code("200");
				res.setStatus_message("success");
				res.setResponse(promo);
				return res;
			}
		}
		else
		{
			res.setStatus_code("404");
			res.setStatus_message("Invalid Promo Code");
			
			return res;
		}
		
		//return res;
	}*/

	
	
	public  boolean containsDigit(String s) {
	    if (s != null && !s.isEmpty()) {
	        for (char c : s.toCharArray()) {
	            if (Character.isDigit(c)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	@Override
	public GenericResponse getPromocodes() {
	
		GenericResponse response=new GenericResponse();
		
		List<PromoCode> promo=customerdao.getPromocodes();
		
		if(promo.isEmpty()){
			
			response.setStatus_code("404");
			response.setStatus_message("No Promocodes");
		}
		
		
		response.setStatus_code("200");
		response.setStatus_message("Promocodes available");
		response.setResponse(promo);
		return response;
	}
}