package com.cogzy.gtruckways.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.expression.ParseException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.w3c.dom.Document;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.BookingResponse;
import com.cogzy.gtruckways.businessObjects.DayWiseResponse;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.DistancePojo;
import com.cogzy.gtruckways.businessObjects.DriverAppBookingResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppLocation;
import com.cogzy.gtruckways.businessObjects.DriverAppResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppTime;
import com.cogzy.gtruckways.businessObjects.DriverAppTripdetailsResponse;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.FcmResponse;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.DriverAppLoginResponse;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.MonthlyWiseResponse;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;

import com.cogzy.gtruckways.businessObjects.VehicleLocationInfo;
import com.cogzy.gtruckways.businessObjects.WeeklyResponse;
import com.cogzy.gtruckways.businessObjects.WeeklyWiseResponse;
import com.cogzy.gtruckways.controller.SendFCMNotification;
import com.cogzy.gtruckways.daoImpl.DriverDaoImpl;
import com.cogzy.gtruckways.daoImpl.GetPriceDaoImpl;
import com.cogzy.gtruckways.daoImpl.TelePostDaoImpl;
import com.cogzy.gtruckways.service.DriverService;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.DriverAppRequestPojo;
import com.google.gson.Gson;


@Configuration
@PropertySource(value="/price.properties",ignoreResourceNotFound=true)
public class DriverServiceImpl implements DriverService {

	
	DriverDaoImpl driverdao;

	@Autowired
	GetPriceServiceImpl priceservice;
	
	@Autowired
	TelePostServiceImpl postService;
	
	TelePostDaoImpl PostDao;
	
	public GetPriceServiceImpl getPriceservice() {
		return priceservice;
	}

	public void setPriceservice(GetPriceServiceImpl priceservice) {
		this.priceservice = priceservice;
	}

	

	public TelePostDaoImpl getPostDao() {
		return PostDao;
	}

	public void setPostDao(TelePostDaoImpl postDao) {
		PostDao = postDao;
	}



	private static Logger log = Logger.getLogger(Log.class.getName());
	
	public DriverDaoImpl getDriverdao() {
		return driverdao;
	}

	public void setDriverdao(DriverDaoImpl driverdao) {
		
		this.driverdao = driverdao;
	}

GetPriceDaoImpl dao;

	public GetPriceDaoImpl getDao() {
	return dao;
}


public void setDao(GetPriceDaoImpl dao) {
	this.dao = dao;
}


	public DriverAppLoginResponse driverLogin(DriverAppRequestPojo logininfo) {
		
	
		log.info("DriverServiceImpl-->DriverLogin-->MobileNo-->"+logininfo.getMobileNo()+"-->FCMtoken-->"+logininfo.getFcmToken());
		
		DriverAppLoginResponse loginResponse=new DriverAppLoginResponse();
		LocalDateTime time=LocalDateTime.now().withNano(0);
		Vehicle vehi=new Vehicle();
		
		try{
		

			vehi=driverdao.getDriverStatus(logininfo.getMobileNo(), logininfo.getPassword());
			
		
			if(!vehi.getDriverId().getPassword().equals(logininfo.getPassword())||!vehi.getDriverId().getMobile().equals(logininfo.getMobileNo())){ // ||!vehi.getDriverId().getImeiNo().equals(logininfo.getImeiNo()
			
			loginResponse.setStatusMessage("Mobile No or Password is Incorrect");
			loginResponse.setStatusCode(500);
			return loginResponse;
			
			} else if(vehi.getDriverId().getDriverStatus().equals("ENGAGE")||vehi.getDriverId().getDriverStatus().equals("SLEEP")||vehi.getDriverId().getDriverStatus().equals("LOGOUT")||!vehi.getDriverId().getFcmToken().equals(logininfo.getFcmToken()))
		
			{
				
				
				int success=driverdao.updateDriverStatus(logininfo.getMobileNo(),logininfo.getPassword(),logininfo.getImeiNo(),logininfo.getFcmToken());
				int success1=driverdao.updateDriverStatustoSleepOrActive(vehi.getDriverId().getDriverId(),"11",time);
					if(success==0 || success1==0){
					
					loginResponse.setStatusMessage("Login Unsuccessfull");
					loginResponse.setStatusCode(500);
					return loginResponse;
					
					} 
			

				vehi=driverdao.getDriverStatus(logininfo.getMobileNo(), logininfo.getPassword());
				
				if(!vehi.getDriverId().getPassword().equals(logininfo.getPassword())||!vehi.getDriverId().getMobile().equals(logininfo.getMobileNo()))
					{
					
					loginResponse.setStatusMessage("Mobile No and Password is Incorrect");
					loginResponse.setStatusCode(500);
					return loginResponse;
					
					}
				
				
				
				loginResponse.setDriverId(vehi.getDriverId().getDriverId());
				loginResponse.setDriverName(vehi.getDriverId().getDriverName());
				loginResponse.setDriverStatus(vehi.getDriverId().getDriverStatus());
				loginResponse.setStatusMessage("Login Successfull");
				loginResponse.setStatusCode(200);
				return loginResponse;
				
			}else
			  
				{
				
				loginResponse.setDriverId(vehi.getDriverId().getDriverId());
				loginResponse.setDriverName(vehi.getDriverId().getDriverName());
				loginResponse.setDriverStatus(vehi.getDriverId().getDriverStatus());
				loginResponse.setStatusMessage("Login Successfull");
				loginResponse.setStatusCode(200);
				return loginResponse;
				
				
				}		
		
		
		}catch (NullPointerException e)
		
		{
			
			log.error(loginResponse.getDriverName());
			loginResponse.setStatusMessage("Login Unsuccessfull");
			loginResponse.setStatusCode(500);
			return loginResponse;
		
		}
		
		
		
		
		
		
		
		
	}

	@Override
	public DriverAppBookingResponse acceptBookingDetails(String bookingId, int driverId, String acceptDateTime) {
		
		DriverAppBookingResponse bookResponse=new DriverAppBookingResponse();
	
	try{	
		
		Post post=new Post();
		LocalDateTime time=LocalDateTime.now().withNano(0);
		
		post=driverdao.getPostDetails(bookingId);
		
		if(post.getStatus().equals("Vehicle Arranged")|| post.getStatus().equals("Source Reached") || post.getStatus().equals("Loading Completed")|| post.getStatus().equals("Destination Reached")||post.getStatus().equals("Completed")||post.getStatus().equals("Canceled")){
			
			bookResponse.setStatusMessage("Booking is Already Taken");
			bookResponse.setDriverId(0);
			log.info("booking is already taken by some one");
			bookResponse.setStatusCode(401);
			return bookResponse;	
	
			
			
		}

		
		
		int success=driverdao.assignDriverForBooking(bookingId, driverId, acceptDateTime);
		
		
		if(success==0){
			bookResponse.setStatusMessage("Unable to Assign the Driver");
			bookResponse.setStatusCode(500);
			return bookResponse;	
		}
		
		post=driverdao.getBookingDetails(bookingId, driverId);
		
		if(post.getTotalAmount()==0||post.getUser().getMobileNo().isEmpty()||post.getBookingId().isEmpty()){
			
			bookResponse.setStatusMessage("Unable to Assign the Driver");
			bookResponse.setStatusCode(500);
			return bookResponse;	
		
		} else{
		
			VehicleLocationInfo locInfo=driverdao.getVehicleLocation(driverId);
			
			log.info("DriverServiceImpl-->AcceptBookingMethod-->Latitude of Vehicle When Booking Accepted by Driver-->"+locInfo.getCurLat()+"-->Longitude of Vehicle When Booking Accepted by Driver-->"+locInfo.getCurLong());
			
			Route route=getGoogleDistanceAndTimeUsingLatAndLong(locInfo.getCurLat(),locInfo.getCurLong(),post.getsLat(),post.getsLong());
			
			if(locInfo.equals(null)||route.equals(null)){
			
				bookResponse.setStatusMessage("Unable to Find Vehicle");
				bookResponse.setStatusCode(500);
				return bookResponse;
				
			}
			
			int success1=driverdao.insertTripdetailsInAcceptOrder(driverId, bookingId, route);
			
			int success2=driverdao.updateDriverStatustoSleepOrActive(driverId,"22",time);
			
			
			if(success1==0 ||success2==0 ){
				bookResponse.setStatusMessage("Unable to Assign the Driver");
				bookResponse.setStatusCode(500);
				return bookResponse;	
			}
			
			
			
			bookResponse.setUserEmail(post.getUser().getEmail());
			bookResponse.setBookingId(post.getBookingId());
			bookResponse.setTotalAmount(post.getTotalAmount());
			bookResponse.setMobileNo(post.getUser().getMobileNo());
			bookResponse.setUserName(post.getUser().getUserName());
			bookResponse.setPickUpTime(post.getTravelDate());
			bookResponse.setPickupLocation(post.getFromCity());
			bookResponse.setDropLocation(post.getToCity());
			bookResponse.setDriverId(driverId);
			bookResponse.setHelper(post.getHelper());
			bookResponse.setStatusMessage("Booking is assigned to You");
			bookResponse.setDriverStatus("ENGAGE");
			bookResponse.setSourceLat(post.getsLat());
			bookResponse.setSourceLong(post.getsLong());
			bookResponse.setDestLat(post.getdLat());
			bookResponse.setDestLong(post.getdLong());
			bookResponse.setStatusCode(200);
			return bookResponse;	
		}
		
		
		
		
	} catch(NullPointerException e) {
		
		bookResponse.setStatusMessage("Unable to Assign the Driver");
		bookResponse.setStatusCode(500);
		return bookResponse;
	}
	
	
	}

	@Override
	public DriverAppResponse boookingCanceled(String bookingId, int driverId) {
		// TODO Auto-generated method stub
		
		DriverAppResponse appResponse=new DriverAppResponse();
		LocalDateTime time=LocalDateTime.now().withNano(0);
		try{
		int success=driverdao.cancelBooking(bookingId, driverId);
		int success1=driverdao.updateDriverStatustoSleepOrActive(driverId, "11",time);
		if(success==0|| success1==0){
			appResponse.setDriverId(driverId);
			appResponse.setStatusMessage("Incorrect BookingId or DriverId");
			return appResponse;
			
		}
		appResponse.setDriverId(driverId);
		appResponse.setStatusMessage("Booking is Canceled");
		return appResponse;
		
		}catch(NullPointerException e) {
			
			appResponse.setStatusMessage("Unable to Decline a Call");
			return appResponse;
		}
		
	}

	@Override
	public DriverAppResponse onPickupLocation(DriverAppRequestPojo atLocationRequest) {
		// TODO Auto-generated method stub
		
		DriverAppResponse appResponse=new DriverAppResponse();
		
		try{
		
			
			/*float dryRunCharge=0;
			float dryRunKm=0;
			int startdelayTime=0;
			log.info("DriverserviceImpl-->onPickupLocation-->");
			Post post=driverdao.getBookingDetails(atLocationRequest.getBookingId(),atLocationRequest.getDriverId());
			log.info("DriverserviceImpl-->onPickupLocation-->BookingAccepted-->"+post.getAcceptedTime());
			
			
			int exactTime=getDateTimeDiffrence(post.getAcceptedTime(),atLocationRequest.getAppTime());
			TripDetails trip=driverdao.getTripDetailsInPickupLocation(atLocationRequest.getBookingId(),atLocationRequest.getDriverId());
			
			// start trip delay charges
			int bufferTime=trip.getMins_to_source()+20;
			Deductions ded=new Deductions();
			LocalDateTime DateTime=LocalDateTime.now();
		
			if(exactTime>bufferTime){
				
				startdelayTime=exactTime-bufferTime;
				
				
				ded.setCode("DED_STARTDELAY");
				ded.setAmount(200);
				ded.setReason("Start Delay by "+startdelayTime+" Mins");
				ded.setBookId(atLocationRequest.getBookingId());
				ded.setDriverId(atLocationRequest.getDriverId());
				driverdao.addDeductions(ded,DateTime);
				log.info("DriverServicelImpl-->onpickupLocation-->exactTimeTaken"+exactTime+" mins-->onpickupLocation-->Deductions-->startTripdelayTime-->"+startdelayTime+" mins");
			
			}else{
			
				startdelayTime=0;
				ded.setBookId(atLocationRequest.getBookingId());
				ded.setDriverId(atLocationRequest.getDriverId());
				ded.setCode("NO_DEDUCTIONS");
				ded.setReason("No Start Delay");
				driverdao.addDeductions(ded,DateTime);
				log.info("No  Start Trip Delay for this Trip");
				}
			
		
			//  caluculate dryRun
			Incentives incent=new Incentives();
			
			if(trip.getKm_to_source()>3){
				
				dryRunKm=(trip.getKm_to_source()-3);
				dryRunCharge=(dryRunKm)*7;
				
				incent.setBookId(atLocationRequest.getBookingId());
				incent.setDriverId(atLocationRequest.getDriverId());
				incent.setCode("INC_DRYRUN");
				incent.setIncAmount(dryRunCharge);
				driverdao.addIncentives(incent,DateTime);
				
				log.info("DriverServiceImpl-->Onpickuplocation-->Dry Incentives are added-->incentiveAmount-->"+dryRunCharge+"-->dryRunKm-->"+dryRunKm);
				
				
			} else {
			
				dryRunKm=0;
				incent.setBookId(atLocationRequest.getBookingId());
				incent.setDriverId(atLocationRequest.getDriverId());
				incent.setCode("NO_INCENTIVES");
				driverdao.addIncentives(incent,DateTime);
				log.info("No Dry Run for This Trip");
			}
	
			
			int success=driverdao.updateTripDetailsAtPickupLocation(atLocationRequest,DateTime,dryRunKm,startdelayTime);

		if(success==0){
			appResponse.setDriverId(atLocationRequest.getDriverId());
			appResponse.setStatusMessage("Pickup Location is Incorrect");
			return appResponse;
			
		}*/
		
		int success1=driverdao.updateBookingStatusAtLocation(atLocationRequest);
		
		if(success1==0){
			appResponse.setDriverId(atLocationRequest.getDriverId());
			appResponse.setStatusMessage("Pickup Location is Incorrect");
			appResponse.setStatusCode(500);
			return appResponse;
			
		}
		
		
		appResponse.setDriverId(atLocationRequest.getDriverId());
		appResponse.setStatusMessage("Vehicle At PickUp Location");
		appResponse.setStatusCode(200);
		return appResponse;
		
		}catch(NullPointerException e) {
			
			appResponse.setStatusMessage("Vehicle is not loaded");
			appResponse.setStatusCode(500);
			return appResponse;
		}	
		
	}

	@Override
	public DriverAppResponse atTripStart(DriverAppRequestPojo tripStart) {
		// TODO Auto-generated method stub
		DriverAppResponse appResponse=new DriverAppResponse();
		try{
		
			int success=driverdao.updateBookingStatusAtStart(tripStart);

			if(success==0){
				appResponse.setDriverId(tripStart.getDriverId());
				appResponse.setStatusMessage("Vehicle is not loaded");
				appResponse.setStatusCode(500);
				return appResponse;
				
			}
		
			appResponse.setDriverId(tripStart.getDriverId());
			appResponse.setStatusMessage("Vehicle is Loaded");
			appResponse.setStatusCode(200);
			return appResponse;
			
			}catch(NullPointerException e) {
				
				appResponse.setStatusMessage("Vehicle is not loaded");
				appResponse.setStatusCode(500);
				return appResponse;
			}
			
		
		
	
	}

	@Override
	public DriverAppResponse onDropLocation(DriverAppRequestPojo atdrop) {
		DriverAppResponse appResponse=new DriverAppResponse();
		try{
		
			int success=driverdao.updateBookingStatusAtDropLocation(atdrop);

			if(success==0){
				
				appResponse.setStatusCode(500);
				appResponse.setStatusMessage("Vehicle is Not At PickUpLocation");
				return appResponse;
				
			}
		
			appResponse.setDriverId(atdrop.getDriverId());
			appResponse.setStatusCode(200);
			appResponse.setStatusMessage("Vehicle Reaches the Destination");
			return appResponse;
			
			}  catch(NullPointerException e) {
				
				appResponse.setStatusCode(500);
				appResponse.setStatusMessage("Vehicle is Not At PickUpLocation");
				return appResponse;
			}
	}

	@Override
	public DriverAppTripdetailsResponse atTripCompelete(DriverAppRequestPojo tripComplete) {
		// TODO Auto-generated method stub
		Price price=new Price();
		
		
		
		DriverAppTripdetailsResponse tripResponse=new DriverAppTripdetailsResponse();
		
		try{
		
			
			LiveTracking live=new LiveTracking();
			double dist=0;
			double distance=0;
			List<LiveTracking> lt1=new ArrayList<LiveTracking>();
		
		
	    int success1=driverdao.updateBookingStatusAfterTripComplete(tripComplete);
		
			
		Post post=driverdao.getBookingDetails(tripComplete.getBookingId(),tripComplete.getDriverId());
		
		log.info("DriverRestController-->DriverServiceImpl-->atTripCompleteMethod-->Vehicle Source Reached Time--->"+post.getSrcReachedDateTime()+"Dest Reached Time"+tripComplete.getAppTime());
		
		
		
		
		int totalTripTime=getDateTimeDiffrence(post.getSrcReachedDateTime(),tripComplete.getAppTime());
		
		log.info("total Mins--> "+totalTripTime);
		
		List<LiveTracking> lt=driverdao.getVehicleTracking(tripComplete.getDriverId(),post.getSrcReachedDateTime(),tripComplete.getAppTime());
		
		
		try{
		
		for(int i=0;i<lt.size();i++){
		
		
			dist=live.distance(Double.parseDouble(lt.get(i).getLatitude()),Double.parseDouble(lt.get(i).getLongitude()),Double.parseDouble(lt.get(i+1).getLatitude()),Double.parseDouble(lt.get(i+1).getLongitude()));
			
			
			
			if(dist>0.050 || i==0){
				
				LiveTracking live1=new LiveTracking();
				
				if(i==0){
					
					live1.setLatitude(lt.get(0).getLatitude());
					live1.setLongitude(lt.get(0).getLongitude());
					live1.setCurrentTime(lt.get(0).getCurrentTime());
				}
				
				live1.setLatitude(lt.get(i).getLatitude());
				live1.setLongitude(lt.get(i).getLongitude());
				live1.setCurrentTime(lt.get(i).getCurrentTime());
				live1.setLatitude(lt.get(i+1).getLatitude());
				live1.setLongitude(lt.get(i+1).getLongitude());
				live1.setCurrentTime(lt.get(i+1).getCurrentTime());
			
				
				distance=distance+dist;
				
				lt1.add(live1);
			
				
			} 
		
		
			}
		

		} catch(Exception e){
			
			
			
		}
		
		
		log.info("Total Distance-->"+distance);
		
	
		DecimalFormat df = new DecimalFormat("#.##");      
		distance = Double.valueOf(df.format(distance));
		
		log.info("distance is-->"+distance);
		
		Route rt=new Route();
		
		float distance1=(float) distance;
		rt.setDistance(distance1);
		rt.setTime(totalTripTime);
	    
		
		price=priceservice.getTotalAmount(rt,post.getInfoTruck());
		
		log.info("Base Calculation-->"+price.getTotalAmount()+"src Time-->"+post.getSrcReachedDateTime()+"--helper-->"+post.getHelper());
		
		
		
		AmountDetails amt=postService.getFinalAmount(post.getSrcReachedDateTime(),post.getHelper(),price.getTotalAmount(),price.getInfo().getLabourPrice(),post.getDiscountAmount(),price.getOtherAmount());
		
	/*	float totalAmount=0;
		
		 
		 log.info("Total Amount Calculation-->"+amt.getTotalAmount());
		
		 float gst=(float) (amt.getTotalAmount()*0.05);
		totalAmount=amt.getTotalAmount()+gst;*/
		
		log.info("TelePostserviceImpl-->updateAdditionalPriceMethod-->totalAmount-->"+amt.getTotalAmount()+"-->NightCharges-->"+amt.getNightCharges()+"totalKm-->"+price.getTotalDistanceKm()+"-->"+price.getTotalMins()+"-->"+price.getExtraKmAmount()+"-->"+price.getExtraMinsAmount());
		
		price.setTotalAmount(amt.getTotalAmount());
		post.setStatus("Trip Finished");
		post.setGstAmount(0);
		post.setNightCharges(amt.getNightCharges());
		post.setBookingId(tripComplete.getBookingId());
		
		
		float helperAmount=post.getHelper()*post.getInfoTruck().getLabourPrice();
		post.setHelperAmount(helperAmount);  //helper amount
			
		log.info(helperAmount);
		
		int sucess=PostDao.updatePostInformationAfterTripComplete(post,price);
		
		log.info(sucess);
		if(sucess==0){
			
			tripResponse.setStatusMessage("Trip is not Completed");
			tripResponse.setStatusCode(500);
			return tripResponse;
			
		}
		
		
		LocalDateTime date=LocalDateTime.now().withNano(0);
		
		int changeStatus=driverdao.updateDriverStatustoSleepOrActive(post.getDriver().getDriverId(), "11",date);
		
	
		
		
		
		
		
		
		
		
		
		
	
		
		//tripResponse.setWaitingTime(amt.getExtraMins());
		tripResponse.setBookingId(post.getRefPostId());
		tripResponse.setDriverId(tripComplete.getDriverId());
		tripResponse.setTotalAmount(amt.getTotalAmount());
		tripResponse.setTotalKm(distance);
		tripResponse.setTotalMins(totalTripTime);
		tripResponse.setStatusMessage("Trip is Completed");
		tripResponse.setUserType(post.getUserType());
		tripResponse.setMaterial(post.getMaterial());
		tripResponse.setStatusCode(200);
		return tripResponse;
		
		}catch(NullPointerException e) {
			
			tripResponse.setStatusMessage("Trip is not Completed");
			tripResponse.setStatusCode(500);
			return tripResponse;
		}
}
	


public AmountDetails getCommissionDetails(Price  price,Post post){
	
	
	AmountDetails amt=new AmountDetails();
	
	float totalAmount=0;
	float additionalKm=0;
	int additionalMins=0;
	float additionalAmount=0;
	if(price.getTotalDistanceKm()>post.getApproximateKm()){
		
		additionalKm=(price.getTotalDistanceKm()-post.getApproximateKm());
		
	}else
	{
		additionalKm=0;
	}
	
	if(price.getTotalMins()>post.getApproximateMins()){
	
		if(price.getTotalMins()>60){ 
			  additionalMins=(int) (price.getTotalMins()-60);
			  } 
		else  {
			   additionalMins=0;
			  }
	}else
	{
		additionalMins=0;	
	}

	/*if(price.getTotalAmount()>post.getApproximateAmount()){
		
		additionalAmount=price.getTotalAmount()-post.getApproximateAmount();
		
		
	} else{
		
		additionalAmount=0;
	}
	*/
	
	String[] d1=post.getSrcReachedDateTime().split("\\s+");
	String s[]=d1[1].split(":");
	int sourceReachedHour=Integer.parseInt(s[0]);
	
	if(sourceReachedHour>=0 && sourceReachedHour<8||sourceReachedHour>=20&&sourceReachedHour<=23){
	
		totalAmount=(float)(price.getTotalAmount()*1.5);
		System.out.println("amount"+totalAmount);
	} else{
		
		totalAmount=price.getTotalAmount();
	}
	
	if(totalAmount>post.getApproximateAmount()){
		
		additionalAmount=totalAmount-post.getApproximateAmount();
		
		
	} else{
		
		additionalAmount=0;
	}
	
	float gtruckwaysAmount=(float) (totalAmount*(0.07));
	float transporterAmount=totalAmount-gtruckwaysAmount;	
	
	
	
	amt.setExtraKm(additionalKm);
	amt.setExtraMins(additionalMins);
	amt.setAdditionalAmount(additionalAmount);
	amt.setCustomerAmount(totalAmount);
	amt.setTransporterAmount(transporterAmount);
	amt.setGtruckwaysAmount(gtruckwaysAmount);
	return amt;
	
	
	
}
	
	
	@Override
	public DriverAppLoginResponse updateDriverStatus(int driverId, String driverStatus) {
		DriverAppLoginResponse statusResponse=new DriverAppLoginResponse();
		
		try{
			
			LocalDateTime time=LocalDateTime.now().withNano(0);
			
			int success=driverdao.updateDriverStatustoSleepOrActive(driverId, driverStatus,time);
			
			
			
			
			if(success==0){
				
				statusResponse.setStatusCode(500);
				statusResponse.setStatusMessage("Incorrect DriverId or Status Code");
				return statusResponse;
				
			} else{
				
				statusResponse.setStatusCode(200);
				statusResponse.setStatusMessage("Status is Updated Succesfully");
				return statusResponse;
				
			}
			
		} catch(NullPointerException e){
			
			statusResponse.setStatusCode(500);
			statusResponse.setStatusMessage("Unable to Update");
			return statusResponse;
			
		}
	}

	
	
	
	
		
		
		
	
	
	
	
	
		
		
	
public  String[] getLatLongPositions(String address) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true"; //&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8
	    System.out.println("URL : "+api);
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    if(responseCode == 200)
	    {
	    	
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         return new String[] {latitude, longitude};
	      }
	      else
	      {
	         throw new Exception("Error from the API - response status: "+status);
	      }
	    }
	    return null;
	  }	
	
	
	
	
	
	
	
	
	
	
public Route getGoogleDistanceAndTimeUsingLatAndLong(double sLat,double sLong,double dLat, double dLong){
		
		String distance="";
		String time="";
		String s="";
		 
		log.info("DriverServiceImpl-->getGoogleDistanceAndTimeUsingLatAndLong-->Source Lat"+sLat+"-->Source Long-->"+sLong+"-->Destination Lat-->"+dLat+"-->Destination Long-->"+dLong);
		
	try{	
	        	
        	 URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+sLat+","+sLong+"&destinations="+dLat+","+dLong+"&mode=driving&language=English&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8");
             
        	// URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins='"+fromCity+"'&destinations='"+toCity+"'&mode=driving&language=English&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8");
             System.out.println(url);
        	 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");
             String line, outputString = "";
             BufferedReader reader = new BufferedReader(
             new InputStreamReader(conn.getInputStream()));
             while ((line = reader.readLine()) != null) 
             {
                 outputString += line;
             }
            log.info("DriverServiceImpl-->GoogleDistanceUsingLatandLong-->Json outPut String-->"+outputString);
             
       
             Gson ob=new Gson();
             DistancePojo capRes = ob.fromJson(outputString, DistancePojo.class);
             System.out.println(capRes);
             
             JSONObject json = new JSONObject(outputString);
             json.get("rows");
             
             json.get("destination_addresses");
             String origin=json.get("origin_addresses").toString();
             JSONArray arr=null;
             JSONArray arr1=null;
             arr = json.getJSONArray("rows");
             arr1=json.getJSONArray("origin_addresses");
             
             
             distance =(String)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text").toString();
          
             time=(String)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text").toString();
       
             
            /* String originaddress="";
             StringBuilder stringBuilderDestinationAddr = new StringBuilder();

             for (int i = 0; i < origin.length(); i++)
                 if (origin.charAt(i) != '[' && origin.charAt(i) != ']' && origin.charAt(i) != '"')
                      stringBuilderDestinationAddr.append(originaddress.origin(i));

             String strCleanDestination = stringBuilderDestinationAddr.toString();*/
             
             
             
             log.info("GoogleApIMethod-->googleDistanceInKm-->"+distance+"googleTimeInHoursAndMinutes"+time);
        
          
             
             
             
		 String[] part = distance.split(" ");
		  float dist=Float.parseFloat(part[0]);
		  float googleDistance=0;
		 
		  if(distance.contains("k")){
        	  
			  googleDistance=dist;
          } else{
        	  
        	  googleDistance=(float) (dist* 0.001);
        	  
          }
		  
		  
		  Route rt=new Route();
		  int time_in_mins=rt.getMinutes(time);
		  log.info("GoogleApIMethod-->googleDistance-->"+dist+"googleTimeInMinutes"+time_in_mins);
		  rt.setDistance(googleDistance);
		  rt.setTime(time_in_mins);
		  return rt;
		
		
	}catch(Exception e){
		
		e.printStackTrace();

	} 
	return null;
	}
	
// get full trip time


public  int getTimeBetweenStartAndStop(String startTime,String endTime){
	
	
	String[] tokens = startTime.split(":");
	int sHours = Integer.parseInt(tokens[0]);
	int sMinutes = Integer.parseInt(tokens[1]);
	//int sSeconds = Integer.parseInt(tokens[2]);
	int sDuration = 60 * sHours + sMinutes;
	
	
	String[] tokens1 = endTime.split(":");
	int eHours = Integer.parseInt(tokens1[0]);
	int eMinutes = Integer.parseInt(tokens1[1]);
	//int eSeconds = Integer.parseInt(tokens1[2]);
	int eDuration = 60 * eHours + eMinutes;
	System.out.println("sDuration"+sDuration);
	System.out.println("eDuration"+eDuration);
	int tripTime=eDuration-sDuration;
	
	System.out.println("triptime"+tripTime);
	
	return tripTime;
	
	
	
}

@Override
public LocalDriver getDriverForPushNotification(Post pos) {
 // TODO Auto-generated method stub
 LocalDriver driver=new LocalDriver();
 
 try{
 
 driver=driverdao.getDriverForPushNotifications(pos);
 driver=driverdao.getFcmRegistrationToken(driver.getDriverId());
 
 
 log.info("DriverSerivceImpl-->Fcm Notification-->bookingId-->"+pos.getBookingId()+"DriverId-->"+driver.getDriverId());
 int success=SendFCMNotification.pushFCMNotification(driver.getFcmToken(),pos);
 
 if(success==0){
	 
	 driver.setDriverId(0);
	 return driver;
 }
 
//int success= driverdao.updateDriverStatustoSleepOrActive(driver.getDriverId(),"22");
 
 
 
 
 } catch(Exception e ){
  e.printStackTrace();
  
  driver.setDriverId(0);
	 return driver;
 }
 
 return driver;
 }


public LocalDriver getManuallyDriverForPushNotification(Post pos,int driverId) {
	 // TODO Auto-generated method stub

	 LocalDriver driver=new  LocalDriver();
	 try{
	 
	 //driver=driverdao.getManuallyDriverForPushNotifications(pos);
		 driver=driverdao.getFcmRegistrationToken(driverId);
	 
	log.info("DriverId-->"+driver.getDriverId()); 
	 log.info("DriverSerivceImpl-->Fcm Notification-->bookingId-->"+pos.getBookingId());
	 int success=SendFCMNotification.pushFCMNotification(driver.getFcmToken(),pos);
	 
	 if(success==0){
		 
		 driver.setDriverId(driver.getDriverId());
		 return driver;
	 }
	 
	/*LocalDateTime dt=LocalDateTime.now().withNano(0); 
	int success1= driverdao.updateDriverStatustoSleepOrActive(driver.getDriverId(),"22",dt);*/
	 
	 return driver; 
	 
	 
	 } catch(Exception e ){
	  e.printStackTrace();
	  
	  driver.setDriverId(0);
		 return driver;
	 }
	 
	
	 }


@Override
public DriverAppResponse locationDetails(DriverAppRequestPojo update) {
	
	DriverAppResponse appResponse=new DriverAppResponse();
	try{
		
	double latitude=update.getSourceLat();
	double longitude=update.getSourceLong();

	
	
	int success=driverdao.updateVehicleLocation(latitude, longitude, update.getDriverId(),update.getAppTime(),update.getStatus());
	
	if(success==0){
		appResponse.setDriverId(0);
		appResponse.setStatusCode(401);
		appResponse.setStatusMessage("Unable to update Location");
		return appResponse;
		
	}
	appResponse.setDriverId(update.getDriverId());
	appResponse.setStatusCode(200);
	appResponse.setStatusMessage("Location is Updated");
	return appResponse;
	
	}catch(NullPointerException e) {
		
		appResponse.setDriverId(0);
		appResponse.setStatusCode(500);
		appResponse.setStatusMessage("Unable to update Location");
		return appResponse;
	}
}



@Override
public DayWiseResponse getDailyIncentives(int driverId) {

	DayWiseResponse daywise=new DayWiseResponse();
	
	LocalDate currentDate= DriverAppTime.getCurrentDate();
	
	
try{	
	
	
	daywise=driverdao.getSumOfDailyTripFares(driverId, currentDate);
	int sumIncentivesOfDay=driverdao.getSumOfDailyIncentives(driverId, currentDate);
	int sumDeductionsOfDay=driverdao.getSumOfDailyDeductions(driverId, currentDate);
	daywise.setTotalDeductions(sumDeductionsOfDay);
	daywise.setTotalIncentives(sumIncentivesOfDay);
	
	float driverAmount=(daywise.getTotalTripEarinings()+sumIncentivesOfDay)-sumDeductionsOfDay;
	daywise.setTotaldriverAmount(driverAmount);
	
	List<BookingResponse> bookresponse=driverdao.getAllBookingsOfTheDay(driverId, currentDate);
	
	
	int sumIncetives=0;
	int sumDeductions=0;
	for(BookingResponse resp:bookresponse){
		
		sumIncetives=driverdao.getAllIncentivesOfBooking(driverId, currentDate, resp.getBookingId());
		
		 resp.setSumIncentives(sumIncetives);
		 
		 sumDeductions=driverdao.getAllDeductionsOfBooking(driverId, currentDate, resp.getBookingId());
		 resp.setSumDeductions(sumDeductions);
	}
	
	
	
	daywise.setBookwise(bookresponse);
	
	
	
	
	return daywise;
}
catch(Exception e){
	
	
	daywise.setStatusCode(500);
	return daywise;
}
	
	
}


@Override
public WeeklyWiseResponse getWeeklyIncentives(int driverId) {
	
	WeeklyWiseResponse weekwise=new WeeklyWiseResponse();
	List<BookingResponse> bookresponse =new ArrayList<BookingResponse>();
	
	try{
	DriverAppTime weekdates=DriverAppTime.getCurrentWeek();
	
	log.info("weeklyincent"+weekdates.getWeekStartDate()+"endDate"+weekdates.getWeekEndDate());
	
	
	weekwise=driverdao.getSumOfWeeklyTripFares(weekdates.getWeekStartDate(), weekdates.getWeekEndDate(), driverId);
	
	log.info("weeklyincent-->TotalCashCollect"+weekwise.getTotalCashCollect()+"-->TotalTripEarnings"+weekwise.getTotalTripEarinings());
	
	int sumIncetivesOfWeek=driverdao.getSumOfWeeklyIncentives(weekdates.getWeekStartDate(), weekdates.getWeekEndDate(), driverId);
	
	log.info("weeklyincent-->SumIncentives of the Week-->"+sumIncetivesOfWeek);
	
	int sumDeductionsOfWeek=driverdao.getSumOfWeeklyDeductions(weekdates.getWeekStartDate(), weekdates.getWeekEndDate(), driverId);
	

	weekwise.setTotalIncentives(sumIncetivesOfWeek);
	weekwise.setTotalDeductions(sumDeductionsOfWeek);
	
	log.info("weeklyincent-->Sum Deductions of the Week-->"+sumDeductionsOfWeek);
	float driverAmount=(weekwise.getTotalTripEarinings()+sumIncetivesOfWeek)-sumDeductionsOfWeek;
	weekwise.setTotaldriverAmount(driverAmount);
	

	if(weekwise.getStatusCode()==404 || sumIncetivesOfWeek==0||sumDeductionsOfWeek==0){
		
		weekwise.setStatusCode(weekwise.getStatusCode());
		weekwise.setStatusMessage("Internal Server Error");
		weekwise.setDaywise(bookresponse);
		return weekwise;
		
	}
	
	
	
	 bookresponse=driverdao.getAllBookingsOfTheWeekly(weekdates.getWeekStartDate(), weekdates.getWeekEndDate(), driverId);
	
	int sumIncetivesofDay=0;
	int sumDeductionsofDay=0;
			for(BookingResponse resp:bookresponse){
		
				log.info("DriverServiceImpl-->Total Incentives of The Day -->"+resp.getDateAndTime());
					sumIncetivesofDay=driverdao.getAllIncentivesOfDaily(resp.getDateAndTime(), driverId);
					resp.setSumIncentives(sumIncetivesofDay);
					log.info("DriverServiceImpl-->Total Incentives of The Day -->"+sumIncetivesofDay);
					sumDeductionsofDay=driverdao.getAllDeductionsOfDaily(resp.getDateAndTime(), driverId);
					resp.setSumDeductions(sumDeductionsofDay);
					log.info("DriverServiceImpl-->Total Deductions of The Day -->"+sumIncetivesofDay);
				}
	
	log.info("DriverServiceImpl-->Weekly wise-->"+sumIncetivesofDay);
	
	weekwise.setDaywise(bookresponse);
	
	return weekwise;

	}
	catch(Exception e){
		
		
		weekwise.setStatusCode(500);
		weekwise.setStatusMessage("Internal Server Error");
		return weekwise;
	}


}

	
	
	

@Override
public MonthlyWiseResponse getMonthlyIncentives(int driverId) {
	
	MonthlyWiseResponse weekwise=new MonthlyWiseResponse();
	List<WeeklyResponse> listResp=new ArrayList<WeeklyResponse>();
	
	try{
	DriverAppTime monthAndYear=DriverAppTime.getCurrentMonthAndYearAndWeekSlabs();
	
	
	
	weekwise=driverdao.getSumOfMonthlyTripFares(monthAndYear.getCurrentMonth(),monthAndYear.getCurrentYear(), driverId);
	
	
	int sumIncentivesOfMonth=driverdao.getSumOfMonthlyIncentives(monthAndYear.getCurrentMonth(),monthAndYear.getCurrentYear(), driverId);
	int sumDeductionsOfMonth=driverdao.getSumOfMonthlyDeductions(monthAndYear.getCurrentMonth(),monthAndYear.getCurrentYear(), driverId);
	
	weekwise.setTotalIncentives(sumIncentivesOfMonth);
	weekwise.setTotalDeductions(sumDeductionsOfMonth);

	
	float driverAmount=(weekwise.getTotalTripEarinings()+sumIncentivesOfMonth)-sumDeductionsOfMonth;
	weekwise.setTotaldriverAmount(driverAmount);
	
	
	
	if(weekwise.getStatusCode()==404 || sumIncentivesOfMonth==0||sumDeductionsOfMonth==0){
		
		weekwise.setStatusCode(weekwise.getStatusCode());
		weekwise.setWeekwise(listResp);
		weekwise.setStatusMessage("No Incentives and Deduction Found");
		return weekwise;
		
	}
	
	
	
	
	
	
	if( monthAndYear.getTodayDate().isBefore(monthAndYear.getFirstWeekEndDate())){
		
		WeeklyResponse resp1 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumIncetivesofweek=driverdao.getSumOfWeeklyIncentives(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumDeductionsofweek=driverdao.getSumOfWeeklyDeductions(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		resp1.setIncentives(sumIncetivesofweek);
		resp1.setDeductions(sumDeductionsofweek);
		listResp.add(resp1);
		weekwise.setWeekwise(listResp);
		
	} else if( monthAndYear.getTodayDate().isBefore(monthAndYear.getSecondWeekEndDate())){
		
		WeeklyResponse resp1 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumIncetivesofweek1=driverdao.getSumOfWeeklyIncentives(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumDeductionsofweek1=driverdao.getSumOfWeeklyDeductions(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		resp1.setIncentives(sumIncetivesofweek1);
		resp1.setDeductions(sumDeductionsofweek1);
		listResp.add(resp1);
		
		WeeklyResponse resp2 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumIncetivesofweek2=driverdao.getSumOfWeeklyIncentives(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumDeductionsofweek2=driverdao.getSumOfWeeklyDeductions(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		resp2.setIncentives(sumIncetivesofweek2);
		resp2.setDeductions(sumDeductionsofweek2);
		listResp.add(resp2);
	
		weekwise.setWeekwise(listResp);
		
	
	} else if( monthAndYear.getTodayDate().isBefore(monthAndYear.getThirdWeekEndDate())){
	
	
		WeeklyResponse resp1 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumIncetivesofweek1=driverdao.getSumOfWeeklyIncentives(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumDeductionsofweek1=driverdao.getSumOfWeeklyDeductions(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		resp1.setIncentives(sumIncetivesofweek1);
		resp1.setDeductions(sumDeductionsofweek1);
		listResp.add(resp1);
		
		WeeklyResponse resp2 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumIncetivesofweek2=driverdao.getSumOfWeeklyIncentives(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumDeductionsofweek2=driverdao.getSumOfWeeklyDeductions(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		resp2.setIncentives(sumIncetivesofweek2);
		resp2.setDeductions(sumDeductionsofweek2);
		listResp.add(resp2);
	
		WeeklyResponse resp3 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumIncetivesofweek3=driverdao.getSumOfWeeklyIncentives(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumDeductionsofweek3=driverdao.getSumOfWeeklyDeductions(monthAndYear.getThirdWeekStartDate(), monthAndYear.getThirdWeekEndDate(), driverId);
		resp3.setIncentives(sumIncetivesofweek3);
		resp3.setDeductions(sumDeductionsofweek3);
		listResp.add(resp3);
		
		weekwise.setWeekwise(listResp);
	
		
	} else{
		
		
		WeeklyResponse resp1 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumIncetivesofweek1=driverdao.getSumOfWeeklyIncentives(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		int sumDeductionsofweek1=driverdao.getSumOfWeeklyDeductions(monthAndYear.getFirstWeekStartDate(), monthAndYear.getFirstWeekEndDate(), driverId);
		resp1.setIncentives(sumIncetivesofweek1);
		resp1.setDeductions(sumDeductionsofweek1);
		listResp.add(resp1);
		
		WeeklyResponse resp2 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumIncetivesofweek2=driverdao.getSumOfWeeklyIncentives(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		int sumDeductionsofweek2=driverdao.getSumOfWeeklyDeductions(monthAndYear.getSecondWeekStartDate(), monthAndYear.getSecondWeekEndDate(), driverId);
		resp2.setIncentives(sumIncetivesofweek2);
		resp2.setDeductions(sumDeductionsofweek2);
		listResp.add(resp2);
	
		WeeklyResponse resp3 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getThirdWeekStartDate(), monthAndYear.getThirdWeekEndDate(), driverId);
		int sumIncetivesofweek3=driverdao.getSumOfWeeklyIncentives(monthAndYear.getThirdWeekStartDate(), monthAndYear.getThirdWeekEndDate(), driverId);
		int sumDeductionsofweek3=driverdao.getSumOfWeeklyDeductions(monthAndYear.getThirdWeekStartDate(), monthAndYear.getThirdWeekEndDate(), driverId);
		resp3.setIncentives(sumIncetivesofweek3);
		resp3.setDeductions(sumDeductionsofweek3);
		listResp.add(resp3);
		
		
		WeeklyResponse resp4 =driverdao.getAllWeekWiseBookingsOfTheMonthly(monthAndYear.getFourthWeekStartDate(), monthAndYear.getFourthWeekEndDate(), driverId);
		int sumIncetivesofweek4=driverdao.getSumOfWeeklyIncentives(monthAndYear.getFourthWeekStartDate(), monthAndYear.getFourthWeekEndDate(), driverId);
		int sumDeductionsofweek4=driverdao.getSumOfWeeklyDeductions(monthAndYear.getFourthWeekStartDate(), monthAndYear.getFourthWeekEndDate(), driverId);
		resp4.setIncentives(sumIncetivesofweek4);
		resp4.setDeductions(sumDeductionsofweek4);
		listResp.add(resp4);
		
		
		weekwise.setWeekwise(listResp);
		
	}
	
	return weekwise;
	
	}catch(Exception e){
		
		
		weekwise.setStatusCode(500);
		weekwise.setStatusMessage("Internal Server Error");
		return weekwise;
	}
		
		
	
	
	
	
}











@Override
public DriverAppResponse finishTrip(int driverId, String bookingId) {
	// TODO Auto-generated method stub
	
	
	DriverAppResponse finishResponse=new DriverAppResponse();
	
	try{
	
	LocalDateTime time=LocalDateTime.now().withNano(0);
	
	log.info("driverId-->"+driverId+"bookingId-->"+bookingId);
	Post pos=driverdao.getBookingDetails(bookingId,driverId);
	
	
	float gst;
	float totalAmount=pos.getTotalAmount();
	
	if(!pos.getGstNumber().equals("GGGG")){
		
		gst =0;
		
		totalAmount=totalAmount+gst; 
		pos.setGstAmount(gst);
		
	} else{
	
	
	if(totalAmount>=1500){
	
		gst =(float) (totalAmount*0.05);
	
		totalAmount=totalAmount+gst;
		pos.setGstAmount(gst);
		
		} else{
			
			gst =0;
			
			totalAmount=totalAmount+gst;
			pos.setGstAmount(gst);
			
			
		}

	}
	
	log.info("totalAmount-->"+totalAmount);
	
	float gtruckwaysAmount=(float) (totalAmount*0.07);  // 7% Commision
	
	float driverAmount=totalAmount-gtruckwaysAmount;

	pos.setGtruckwaysAmount(gtruckwaysAmount);
	pos.setDriverAmount(driverAmount);
	pos.setTotalAmount(totalAmount);
	
	
	int success=driverdao.updateBookingStatus(pos, driverId);
	
	
	int success1=driverdao.updateDriverStatustoSleepOrActive(driverId,"11",time);
	
	if(success==0||success1==0){
		
		finishResponse.setStatusMessage("Unable to Complete the Trip");
		finishResponse.setStatusCode(500);
		return finishResponse;
	}
	
	
	finishResponse.setStatusMessage("Trip is Finished");
	finishResponse.setDriverId(driverId);
	finishResponse.setStatusCode(200);
	return finishResponse;
	
	} catch(Exception e){
		
		finishResponse.setStatusMessage("Trip is not Finished");
		finishResponse.setStatusCode(500);
		return finishResponse;
		
	}
	
}

@Override
public DriverAppResponse logoutUser(int driverId) {

	DriverAppResponse logoutResponse=new DriverAppResponse();
	LocalDateTime time=LocalDateTime.now().withNano(0);
	int success=driverdao.updateDriverStatustoSleepOrActive(driverId, "55",time);
	if(success==0){
		
		logoutResponse.setStatusMessage("Logout Unsuccessful");
		logoutResponse.setDriverId(0);
		return logoutResponse;
	}
	logoutResponse.setStatusMessage("Logout Successful");
	logoutResponse.setDriverId(driverId);
	
	return logoutResponse;
}

@Override
public LocalDriver getDriverInformation(int driverId,String bookingId) {
	// TODO Auto-generated method stub
LocalDriver driver=new LocalDriver();
	
	try{
	
	 driver=driverdao.getDriverDetails(driverId);
	
	
	
	
	if(driver.getDriverId()==0){
		
		return driver;
	}
		
		User user=driverdao.getFcmTokenofTheUser(bookingId);
		
		if(user.isActive()){
			
			if(user.getAppUser()==1){
				
				log.info("DriverService Impl-->App User");
				int success=SendFCMNotification.pushFCMNotificationForCustomerApp(user.getFcmToken(),driver,bookingId);
				 
				return driver;
				
			} else{
				
				log.info("DriverService Impl-->Web User");
				return driver;
			}
			
			
			
		}
		
		return driver;
	} catch(Exception e){
		
		return  driver;
		
	}
	
	
	
}


@Override
public Post getUserMobileAndBookInfoForSMS(String bookingId,int driverId) {
	Post post=new Post();
try{
	
	post=driverdao.getBookingDetails(bookingId,driverId);
	
	if(post.getTotalAmount()==0){
		
		return post;
	}
		return post;
	
	}catch(Exception e ){
		
		post.setTotalAmount(0);
		return post;
	}
}

@Override
public FcmResponse updateBookingSatatus(Post bookinfo) {
	
	FcmResponse resp=new FcmResponse();
	try{
	int success=driverdao.UpdateBookingStatusFromCustomerApp("",bookinfo.getRefPostId());
	
	if(success==0){
		
		resp.setStatusCode(404);
		resp.setStatusMessage("No Data Found");
		return resp;
		
	}
	
	resp.setStatusCode(200);
	resp.setStatusMessage("Data Found");
	return resp;
	
	}catch(Exception e){
		
		resp.setStatusCode(500);
		resp.setStatusMessage("Internal Server Error");
		return resp;
		
	}
}

//uploading image driverId with description from driverApp 
@Override
public DriverAppResponse imageuploadform(String date,int driverId,String status,int odometer) {
DriverAppResponse appResponse=new DriverAppResponse();
try{		
	LocalTime time1 = LocalTime.now().withNano(0);
	int success;
	EnterpriseTruckAssign assign=driverdao.getEnterpriseInformation(driverId);
	
	if(status.equalsIgnoreCase("START")){
		
		log.info("Start Reading--->");
		
				success=driverdao.driverimageinsert(date,assign.getEnterpriseId(),odometer,time1);
				
				
	} else{
				
		
		log.info("End Reading--->");
		
		
		
		success=driverdao.driverimageupload(date,assign,odometer,time1);

		int balanceKm=driverdao.getBalanceKmofEnterprise(assign.getEnterpriseId(),assign.getNoOfKms());
		
		log.info("Enterprise Vehicle Id--->"+assign.getEnterpriseId());
		
		
		
		log.info("balanceKM--->"+balanceKm);
		
		float previousDistanceTravelled=assign.getNoOfKms()-balanceKm;
		
		log.info("distance Travelled before"+previousDistanceTravelled);
		
		EnterpriseTripDetails tripinfo=driverdao.getTripDetails(assign.getEnterpriseId(), date);
		
		
		 float todayKm=(int) (odometer-tripinfo.getStartReading());
		 log.info("distance covered today "+todayKm);
		 
		 int todayminutes=getTimeBetweenStartAndStop(tripinfo.getStartReadingTime(),tripinfo.getEndReadingTime());
		 
		 int todayhrs=todayminutes/3600;
		 
		 
		 int additionalHrs=assign.getNoOfhours()-todayhrs;
		 
		 float additionalAmount;
		 
		 if(additionalHrs>0){
			 
			 additionalHrs=additionalHrs*60;
			 additionalAmount=assign.getPricePerAdditionalMin()*additionalHrs;
		 } else{
			 
			 additionalHrs=0;
			 additionalAmount=0;
		 }
		 
		 
		 float balance= balanceKm-todayKm;
		
		 log.info("balance "+balance);
		 
		 float distanceTravelled=previousDistanceTravelled+todayKm;
		 
		 log.info("distance travelled upto "+distanceTravelled);
		 tripinfo.setTodayKm(todayKm);
		 tripinfo.setTodayMins(todayhrs);
		 tripinfo.setAdditionalTime(additionalHrs);
		 tripinfo.setAdditionalAmount(additionalAmount);
		 tripinfo.setBalanceKm(balance);
		 tripinfo.setDistanceTravelled(distanceTravelled);
		 success=driverdao.updateTripDetails(tripinfo,assign.getEnterpriseId(),date);
				
	}
if(success==0){
	appResponse.setDriverId(0);
	appResponse.setStatusMessage("Unable to get image");
	return appResponse;
	
}
appResponse.setDriverId(driverId);
appResponse.setStatusMessage("image is uploaded");
return appResponse;

}catch(NullPointerException e) {
	
	appResponse.setDriverId(0);
	appResponse.setStatusMessage("Unable to upload image");
	return appResponse;
}

}


public int getDateTimeDiffrence(String startDate,String endDate) {  
    
    // Custom date format
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

    Date d1 = null;
    Date d2 = null;
   
    try {
       
    	d1 =  format.parse(startDate);
        d2 =  format.parse(endDate);
    
    
    } catch (ParseException e) {
        e.printStackTrace();
    } catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    

    // Get msec from each, and subtract.
    
    log.info("-->"+d1+"-->"+d2);
    
    long diff = d2.getTime() - d1.getTime();                  

    
    long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
    
    
  /* long days = TimeUnit.MILLISECONDS.toDays(diff);
    long remainingHoursInMillis = diff - TimeUnit.DAYS.toMillis(days);
    long hours = TimeUnit.MILLISECONDS.toHours(remainingHoursInMillis);
    long remainingMinutesInMillis = remainingHoursInMillis - TimeUnit.HOURS.toMillis(hours);
 
    long diffMinutes = diff / (60 * 1000) % 60; 
    long remainingSecondsInMillis = remainingMinutesInMillis - TimeUnit.MINUTES.toMillis(minutes);
    long seconds = TimeUnit.MILLISECONDS.toSeconds(remainingSecondsInMillis);

    System.out.println("Days: " + days + ", hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds+"totalMins"+diffMinutes);
*/
return (int) minutes;

}

@Override
public DriverAppResponse updateMultiplelocationDetails(List<DriverAppLocation> offlineLocations,String driverId) {
	
	DriverAppResponse app=new DriverAppResponse();
	try{
	
	
	driverdao.updateMultiplelocationDetails(offlineLocations);
	
	
	app.setStatusCode(200);
	app.setStatusMessage("Location is Updated");
	return app;
	
	} catch(Exception e){
		
		
		app.setStatusCode(500);
		app.setStatusMessage("Location is Updated");
		return app;
	}
	
}
	


	
}
