package com.cogzy.gtruckways.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cogzy.gtruckways.businessObjects.DriverAppResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppTripdetailsResponse;
import com.cogzy.gtruckways.businessObjects.FcmResponse;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.MonthlyWiseResponse;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.DayWiseResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppBookingResponse;
import com.cogzy.gtruckways.businessObjects.DriverAppLocation;
import com.cogzy.gtruckways.businessObjects.DriverAppLoginResponse;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.WeeklyWiseResponse;
import com.cogzy.gtruckways.service.EmailSenderService;
import com.cogzy.gtruckways.serviceImpl.DriverServiceImpl;
import com.cogzy.gtruckways.serviceImpl.GetPriceServiceImpl;
import com.cogzy.gtruckways.serviceImpl.SmsServiceImpl;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.DriverAppRequestPojo;


@RestController
public class DriverRestController {

	@Autowired
	DriverServiceImpl driverservice;
	
	@Autowired
	GetPriceServiceImpl priceservice;
	@Autowired
	SmsServiceImpl smsservice;
	
	 
	
	 private static final String UPLOAD_DIRECTORY ="/images";  
     
     File file;
	
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	
	
	@RequestMapping(value = "/driver/login", method = RequestMethod.POST)
	public ResponseEntity<DriverAppLoginResponse> getDriverStatus(@RequestBody DriverAppRequestPojo dri,
			BindingResult result) {

		log.info("DRIVER LOGIN API START----------->*********************************");
		
		DriverAppLoginResponse loginResponse = new DriverAppLoginResponse();

		log.info("DriverRestController-->driverLogin-->mobileNo-->" + dri.getMobileNo() + "-->password-->"
				+ dri.getPassword() + "-->fcmToken-->" + dri.getFcmToken() + "-->ImeiNo-->" + dri.getImeiNo());
		
		if (result.hasErrors()
				|| dri.getFcmToken().isEmpty() || dri.getPassword().isEmpty() || dri.getMobileNo().isEmpty()
				|| dri.getImeiNo().isEmpty()) {

			loginResponse.setStatusMessage("Incorrect Input");
			loginResponse.setStatusCode(400);
			return new ResponseEntity<DriverAppLoginResponse>(loginResponse, HttpStatus.OK);
		} else {
			loginResponse = driverservice.driverLogin(dri);

			if (loginResponse.getStatusCode()!=200) {

				loginResponse.setStatusMessage("Incorrect Input");
				
				return new ResponseEntity<DriverAppLoginResponse>(loginResponse, HttpStatus.OK);

			}

			log.info("DRIVER LOGIN API STOP------------------>*********************************");

			return new ResponseEntity<DriverAppLoginResponse>(loginResponse, HttpStatus.OK);
			
			// You
			// many
			// decide
			// to
			// return
			// HttpStatus.NOT_FOUND

		}

	}

	@RequestMapping(value = "/driver/status", method = RequestMethod.POST)

	public ResponseEntity<DriverAppLoginResponse> setDrivertoSleepOrActive(@RequestBody DriverAppRequestPojo ds,
			BindingResult result) throws Exception {

		log.info("DRIVER STATUS API START--------------->*********************************");
		
		log.info("DriverRestController-->driverStatusMethod-->driverId-->" + ds.getDriverId() + "-->driverStatus-->"
				+ ds.getDriverStatus() + "");
		DriverAppLoginResponse statusResponse = new DriverAppLoginResponse();

		if (result.hasErrors() || ds.getDriverStatus().isEmpty() || ds.getDriverId() == 0) {

			statusResponse.setStatusMessage("Incorrect Input");
			statusResponse.setStatusCode(400);
			return new ResponseEntity<DriverAppLoginResponse>(statusResponse, HttpStatus.NOT_FOUND);

		} else {

			statusResponse = driverservice.updateDriverStatus(ds.getDriverId(), ds.getDriverStatus());

			if (statusResponse.getStatusCode()!=200) {
				
				return new ResponseEntity<DriverAppLoginResponse>(statusResponse, HttpStatus.NOT_FOUND);
			}
			statusResponse.setDriverId(ds.getDriverId());
			
			log.info("DRIVER STATUS API STOP------------>*********************************");
	
			return new ResponseEntity<DriverAppLoginResponse>(statusResponse, HttpStatus.OK);

		}

	}
		
	@RequestMapping(value = "/driver/accept", method = RequestMethod.POST)
	public ResponseEntity<DriverAppBookingResponse> acceptBooking(@RequestBody DriverAppRequestPojo ds) {
		
		log.info("ACCEPT API START--------->*********************************");

		DriverAppBookingResponse bookResponse = new DriverAppBookingResponse();

		
		log.info("DriverRestController-->AcceptBookingMethod-->DriverId-->" + ds.getDriverId() + "-->bookingId-->"
				+ ds.getBookingId() + "-->AcceptTime-->" + ds.getAppTime() + "");

		if (!ds.getBookingId().isEmpty() || ds.getDriverId() != 0 || !ds.getAppTime().isEmpty()) {

			
			bookResponse = driverservice.acceptBookingDetails(ds.getBookingId(), ds.getDriverId(), ds.getAppTime());
			
			
			if (bookResponse.equals(null)||bookResponse.getDriverId()==0) {
				
				return new ResponseEntity<DriverAppBookingResponse>(bookResponse, HttpStatus.OK);
			
			}
		
			
			LocalDriver driver=driverservice.getDriverInformation(ds.getDriverId(),bookResponse.getBookingId());
			
			ApplicationContext context = new ClassPathXmlApplicationContext("com/cogzy/gtruckways/controller/applicationContext.xml"); 

			EmailSenderService  mailer =  (EmailSenderService) context.getBean("mailMail");
			
			mailer.SendDriverInfoToCustomer(ds.getBookingId(), driver.getDriverName(),driver.getMobile(),bookResponse.getUserEmail(),driver.getDriverRegNo());
			
			smsservice.getBookingInformationWithDriverName(driver,bookResponse);
			
			
			
			log.info("ACCEPT API STOP------------->*********************************");

			return new ResponseEntity<DriverAppBookingResponse>(bookResponse, HttpStatus.OK);
		
			
			
			
		} else {

			bookResponse.setStatusMessage("Incorrect Input");
			bookResponse.setStatusCode(400);
			return new ResponseEntity<DriverAppBookingResponse>(bookResponse, HttpStatus.OK);
		}

	}
	
	
	@RequestMapping(value = "/driver/decline", method = RequestMethod.POST)
	
	public ResponseEntity<DriverAppResponse> callDecline(@RequestBody DriverAppRequestPojo lr) {
		DriverAppResponse appResponse = new DriverAppResponse();

		log.info("CALL DECLINE API START--------------------->*********************************");

		log.info("DriverRestController-->callDeclineMethod-->bookingId-->" + lr.getBookingId() + "-->driverId-->"
				+ lr.getDriverId());

		if (!lr.getBookingId().isEmpty()) {

			appResponse = driverservice.boookingCanceled(lr.getBookingId(), lr.getDriverId());

			if (appResponse.equals(null)) {

				appResponse.setStatusMessage("Unable to Decline a Call");
				return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.NOT_FOUND);
			}

			log.info("****************************DRIVER APP LOGIN API STOP*********************************");

			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);

		} else {

			appResponse.setStatusMessage("Unable to Decline a Call");
			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.NOT_FOUND);
		}

	}

	
	
	@RequestMapping(value = "/driver/onPickupLocation", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> atPickUplocation(@RequestBody DriverAppRequestPojo pickupRequest) {
		
		DriverAppResponse appResponse = new DriverAppResponse();
		log.info("ON PICKUP LOCATION API START----------------------->*********************************");

		log.info("DriverResController-->onPickupLocation-->driverId-->" + pickupRequest.getDriverId()
				+ "-->bookingId-->" + pickupRequest.getBookingId() + "-->PickUpTime-->" + pickupRequest.getAppTime());

		if (pickupRequest.getBookingId().isEmpty() || pickupRequest.getDriverId() == 0
				|| pickupRequest.getSourceLat() == 0 || pickupRequest.getSourceLong() == 0
				|| pickupRequest.getAppTime().isEmpty()) {

			appResponse.setStatusMessage("Incorrect Input");
			appResponse.setStatusCode(400);
			
			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		
		} else {

			appResponse = driverservice.onPickupLocation(pickupRequest);

			if (appResponse.getStatusCode()!=200) {
				return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
			}

			log.info("ON PICKUP LOCATION API STOP------------------------->*********************************");
			appResponse.setStatusCode(200);
			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);

		}
	}
	
	
	
	@RequestMapping(value = "/driver/start", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> tripStart(@RequestBody DriverAppRequestPojo tripStart) {
		DriverAppResponse appResponse = new DriverAppResponse();
		log.info("START TRIP API START*********************************");

		
		log.info("DriverRestController-->tripStartMethod-->driverId-->" + tripStart.getDriverId() + "-->bookingId-->"
				+ tripStart.getBookingId() + "-->TripStartTime-->" + tripStart.getAppTime());

		if (tripStart.getBookingId().isEmpty() || tripStart.getAppTime().isEmpty() || tripStart.getDriverId() == 0) {

			appResponse.setStatusMessage("Incorrect Input");
			appResponse.setStatusCode(400);
			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		} else {

			appResponse = driverservice.atTripStart(tripStart);

			if (appResponse.getStatusCode()!=200) {
				
				return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
			}
			
			log.info("*START TRIP API STOP-------------------->*********************************");

			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);

		}

	}
	
	
	
	@RequestMapping(value = "/driver/stop", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> onDropLocation(@RequestBody DriverAppRequestPojo stop) {
		DriverAppResponse appResponse = new DriverAppResponse();
		log.info("ON DROP LOCATION API START--------------------------->*********************************");

		log.info("DriverRestController-->onDropLocation-->bookingId-->" + stop.getBookingId() + "-->driverId-->"
				+ stop.getDriverId() + "-->DropLocationTime-->" + stop.getAppTime());

		if (stop.getBookingId().isEmpty() || stop.getDriverId() == 0 || stop.getAppTime().isEmpty()) {

			appResponse.setStatusMessage("Incorrect Input");
			appResponse.setStatusCode(400);
			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		}

		appResponse = driverservice.onDropLocation(stop);

		if (appResponse.getStatusCode()!=200) {

			
			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		}

		log.info("ON DROP LOCATION API STOP----------------------->*********************************");

		return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);

	}
	


	@RequestMapping(value = "/driver/tripComplete", method = RequestMethod.POST)
	public ResponseEntity<DriverAppTripdetailsResponse> TripComplete(@RequestBody DriverAppRequestPojo complete) {
		
		DriverAppTripdetailsResponse appResponse = new DriverAppTripdetailsResponse();
		
		log.info("TRIP COMPLETE API START------------------------>*********************************");

		
		log.info("DriverRestController-->TripCompleteMethod-->BookingId-->" + complete.getBookingId() + "-->DriverId-->"
				+ complete.getDriverId() + "-->TripCompleteTime-->" + complete.getAppTime());

		if (complete.getBookingId().isEmpty() || complete.getAppTime().isEmpty() || complete.getDriverId() == 0) {

			
			appResponse.setStatusMessage("Incorrect Input");
			appResponse.setStatusCode(400);
			return new ResponseEntity<DriverAppTripdetailsResponse>(appResponse, HttpStatus.OK);
		
		} else {

			appResponse = driverservice.atTripCompelete(complete);

			if (appResponse.getStatusCode()!=200) {

			
				return new ResponseEntity<DriverAppTripdetailsResponse>(appResponse, HttpStatus.OK);
			}

			log.info("TRIP COMPLETE API STOP------------------------->*********************************");
	
			return new ResponseEntity<DriverAppTripdetailsResponse>(appResponse, HttpStatus.OK);

		}

	}
	
	
	

	@RequestMapping(value = "/driver/finish", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> FinishTrip(@RequestBody DriverAppRequestPojo fi) {
	
		log.info("FINISH TRIP API START---------------------->*********************************");
	
		DriverAppResponse appResponse=new DriverAppResponse();
		
		log.info("DriverController-->FinishTripMethod-->bookingId"+fi.getBookingId()+"-->DriverId-->"+fi.getDriverId());
		
		if(fi.getBookingId().isEmpty()||fi.getDriverId()==0){
			
			appResponse.setStatusMessage("Incorrect Input");
			appResponse.setStatusCode(400);
			return new ResponseEntity<DriverAppResponse>(appResponse,HttpStatus.OK);
		}
		
		appResponse=driverservice.finishTrip(fi.getDriverId(), fi.getBookingId());
	
		Post post=driverservice.getUserMobileAndBookInfoForSMS(fi.getBookingId(),fi.getDriverId());
		
		if(appResponse.getStatusCode()!=200){
			
			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		}
	
		// Mail Confirmation regarding booking completion
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/cogzy/gtruckways/controller/applicationContext.xml"); 

		EmailSenderService  mailer =  (EmailSenderService) context.getBean("mailMail");
		
		mailer.TripcompletionMail(post.getUser().getEmail(),post.getBookingId(), post.getTotalAmount());
		
		// SMS to the User regarding the booking completion
		
		smsservice.confirmationSmsAfterFinish(post.getUser().getMobileNo(),post.getRefPostId(), post.getTotalAmount());
		
		log.info("FINISH TRIP API STOP-------------------->*********************************");

		return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
	
	}
	
	
	
	@RequestMapping(value = "/driver/logout", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> LogoutUser(@RequestBody DriverAppRequestPojo logout) {
		
		log.info("LOGOUT API START----------------------------->*********************************");

		DriverAppResponse appResponse=new DriverAppResponse();
		
		log.info("DriverController-->DriverLogout-->driverId-->"+logout.getDriverId());
		
		if(logout.getDriverId()==0){
			
			appResponse.setStatusCode(401);
			appResponse.setStatusMessage("Incorrect Input");
			return new ResponseEntity<DriverAppResponse>(appResponse,HttpStatus.NOT_FOUND);
		}
		
		appResponse=driverservice.logoutUser(logout.getDriverId());
		
		if(appResponse.getDriverId()==0){
			
			appResponse.setStatusCode(500);
			return new ResponseEntity<DriverAppResponse>(appResponse,HttpStatus.NOT_FOUND);
		}
		
		log.info("<-----------LOGOUT API STOP--------------------->");
		appResponse.setStatusCode(200);
		return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/driver/updateLocation", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> updateLocation(@RequestBody DriverAppRequestPojo updateLocation) {

		log.debug("****************************DRIVER UPDATE LOCATION API START*********************************");

		log.info("DriverRestController-->update Driver's Location-->DriverId-->" + updateLocation.getDriverId()
				+ "-->Cuurent Latitude-->" + updateLocation.getSourceLat() + " Current Longitude==>"
				+ updateLocation.getSourceLong()+"-->latlongTime-->"+updateLocation.getAppTime());

		DriverAppResponse appResponse=new DriverAppResponse();
		if (updateLocation.getDriverId() == 0 || updateLocation.getSourceLat() == 0
				|| updateLocation.getSourceLong() == 0) {

			appResponse.setStatusCode(401);
			appResponse.setStatusMessage("Input Parameters are Wrong");
			return new ResponseEntity<DriverAppResponse>(appResponse,HttpStatus.OK);
		} else {

			appResponse = driverservice.locationDetails(updateLocation);

			if (appResponse.getStatusCode()!=200) {
				
				return new ResponseEntity<DriverAppResponse>(appResponse,HttpStatus.OK);
			}
			log.debug("UPDATE LOCATION API STOP------------------------>*********************************");

			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		}
	}
	
	
	
	@RequestMapping(value = "/driver/updateMultipleLocation", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> updateMultipleLocationsAtSameTime(@RequestBody DriverAppLocation offlineLocations) {

		log.debug("****************************DRIVER Multiple UPDATE LOCATION API START*********************************");



		

			DriverAppResponse appResponse=new DriverAppResponse();
		
			
	
			appResponse = driverservice.updateMultiplelocationDetails(offlineLocations.getOfflineLocations(),offlineLocations.getDriverId());

			if (appResponse.getStatusCode()==500) {
				
				return new ResponseEntity<DriverAppResponse>(appResponse,HttpStatus.OK);
			}
			
			log.debug("DRIVER Multiple UPDATE LOCATION API STOP------------------------>*********************************");

			return new ResponseEntity<DriverAppResponse>(appResponse, HttpStatus.OK);
		}
	
	
	
	@RequestMapping(value="/driver/daily",method=RequestMethod.POST)
	public ResponseEntity<DayWiseResponse> dailyIncentives(@RequestBody DriverAppRequestPojo incentRequest){
		
		DayWiseResponse daywiseResponse=new DayWiseResponse();
		
		log.info(" DAILY TRIP EARNINGS API START------------>*********************************");
		Log.info("Driver Rest Controller-->dailymethod-->driverid-->"+incentRequest.getDriverId());
		
		// incoming values are wrong
		if(incentRequest.getDriverId()==0){
				
			daywiseResponse.setStatusCode(400);
			daywiseResponse.setStatusMessage("Failure");
			 return new ResponseEntity<DayWiseResponse>(daywiseResponse,HttpStatus.OK);
		}
		
		
		daywiseResponse=driverservice.getDailyIncentives(incentRequest.getDriverId());
		
		
		if(daywiseResponse.getStatusCode()==500){
			daywiseResponse.setStatusCode(500);
			daywiseResponse.setStatusMessage("Failure");
			  return new ResponseEntity<DayWiseResponse>(HttpStatus.OK);
		}else{
			
			
			daywiseResponse.setStatusCode(200);
			daywiseResponse.setStatusMessage("success");
			log.info("DAILY TRIP EARNINGS API STOP----------------------->************");

			return new ResponseEntity<DayWiseResponse>(daywiseResponse,HttpStatus.OK);
		}		
	}
	
	

	
	
	@RequestMapping(value="/driver/weekly",method=RequestMethod.POST)
	public ResponseEntity<WeeklyWiseResponse> weeklyIncentives(@RequestBody DriverAppRequestPojo incentRequest){
		
		WeeklyWiseResponse weekwise=new WeeklyWiseResponse();
		
		log.info("WEEKLY TRIP EARNINGS API START--------------------->*********************************");

		
		Log.info("Driver Rest Controller-->weeklymethod-->driverid-->"+incentRequest.getDriverId());
		
		if(incentRequest.getDriverId()==0){
			
			weekwise.setStatusCode(404);
			weekwise.setStatusMessage("Failure");
			 return new ResponseEntity<WeeklyWiseResponse>(weekwise,HttpStatus.NOT_FOUND);
		}
		
		
		
		weekwise=driverservice.getWeeklyIncentives(incentRequest.getDriverId());
		
		
		
		if(weekwise.getStatusCode()==404||weekwise.getStatusCode()==500){

			
			weekwise.setStatusCode(weekwise.getStatusCode());
			weekwise.setStatusMessage("Failure");
			  return new ResponseEntity<WeeklyWiseResponse>(weekwise,HttpStatus.NOT_FOUND);
		}
		
			weekwise.setStatusCode(200);
			weekwise.setStatusMessage("success");
			
			log.info("WEEKLY TRIP EARNINGS API STOP------------------------->*********************************");

			return new ResponseEntity<WeeklyWiseResponse>(weekwise,HttpStatus.OK);
				
	}
	
	
	
	

	
	@RequestMapping(value="/driver/monthly",method=RequestMethod.POST)
	public ResponseEntity<MonthlyWiseResponse> monthlyIncentives(@RequestBody DriverAppRequestPojo incentRequest){
		
		MonthlyWiseResponse monthResponse=new MonthlyWiseResponse();
		
		log.info("MONTHLY TRIP EARNINGS API START---------------------->*********************************");

		
		Log.info("Driver Rest Controller-->monthlymethod-->driverid-->"+incentRequest.getDriverId());
		if(incentRequest.getDriverId()==0){
			
			monthResponse.setStatusCode(400);
			monthResponse.setStatusMessage("Failure");
			 return new ResponseEntity<MonthlyWiseResponse>(monthResponse,HttpStatus.NOT_FOUND);
		}
		
		monthResponse=driverservice.getMonthlyIncentives(incentRequest.getDriverId());
		
		
		if(monthResponse.getStatusCode()==404||monthResponse.getStatusCode()==500){
			
			monthResponse.setStatusCode(monthResponse.getStatusCode());
			monthResponse.setStatusMessage("Failure");
			  return new ResponseEntity<MonthlyWiseResponse>(HttpStatus.NOT_FOUND);
		}
			
		
		
			log.info("MONTHLY TRIP EARNINGS API STOP-------------------------->*********************************");
			monthResponse.setStatusCode(200);
			monthResponse.setStatusMessage("success");
			return new ResponseEntity<MonthlyWiseResponse>(monthResponse,HttpStatus.OK);
				
	}
	
	
	
	
	
	
	
	


	@RequestMapping(value = "/driver/cancel", method = RequestMethod.POST)
	public ResponseEntity<DriverAppResponse> driverNotReadyToGo(@RequestBody DriverAppRequestPojo lr) {
		
		
		
		
		
		
		return new ResponseEntity<DriverAppResponse>(HttpStatus.OK);
	}
	
	
	
	


	
	
	/*	@RequestMapping(value="/driver/start",method=RequestMethod.POST)
		public ResponseEntity<Route> start(@RequestBody LocationRequestPojo lr){
			
			System.out.println(lr.getdLat());
			
			 // Route route=driverservice.getGoogleDistanceAndTime(lr.getsLat(),lr.getsLong(),lr.getdLat(),lr.getdLong());
			
			
			if(route.getDistance().equals(null)){
				  return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
			}else{
				
				return new ResponseEntity<Route>(route,HttpStatus.OK);
			}		
		}
	
		@RequestMapping(value="/driver/stop",method=RequestMethod.POST)
		public ResponseEntity<Price> stop(){
			
			
			Price price=driverservice.getPriceDetails();
	
			  
			  
			if(price.getTotalAmount()==0){
				  return new ResponseEntity<Price>(HttpStatus.NOT_FOUND);
			}else{
				
				return new ResponseEntity<Price>(price,HttpStatus.OK);
			}		
		}
	
	
	

		@RequestMapping(value="/driver/order",method=RequestMethod.POST)
		public ResponseEntity<Order> order(){
			
			
	
			 Order ord=driverservice.ordersummary();
			
			
			if(ord.getDestination().equals(null)){
				  return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
			}else{
				
				return new ResponseEntity<Order>(ord,HttpStatus.OK);
			}		
		}
	
		
		@RequestMapping(value="/driver/accept",method=RequestMethod.POST)
		public ResponseEntity<Order> accept(){
			
			
	
			 Order ord=driverservice.orderaccept();
			
			
			if(ord.getBookingId().equals(null)){
				  return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
			}else{
				
				return new ResponseEntity<Order>(ord,HttpStatus.OK);
			}		
		}
		
		
		@RequestMapping(value="/driver/updateLocation",method=RequestMethod.POST)
		public ResponseEntity<Integer> updateLocation(){
			
			
	
			 int sucess=driverservice.locationDetails("123456");
			
			
			if(sucess==0){
				  return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
			}else{
				
				return new ResponseEntity<Integer>(sucess,HttpStatus.OK);
			}		
		}
		*/

@RequestMapping(value="/driver",method=RequestMethod.POST)
//@Produces(User.APPLICATION_JSON)
//public ResponseEntity<User>  getlistAllUsers(@RequestBody User user) {
public ResponseEntity<User>  getlistAllUsers(@PathVariable("mobile") String mobile){   
	
	/*User use=new User();
	use=userservice.getUserDetails(user);
    if(use.isActive()){
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
    }*/
	
	System.out.println("appinfo"+mobile);
	//System.out.println("username"+user.getUserName());
	String abc="punith";
	User use =new User();
	use.setMobileNo("8050795014");
	use.setUserName(abc);
	
	System.out.println("hi hello"+abc);
	return new ResponseEntity<User>(use,HttpStatus.OK);
}



//From Customer App


@RequestMapping(value="customer/confirmBooking",method=RequestMethod.POST) 

public ResponseEntity<FcmResponse> confirmBooking(@RequestBody Post pos) throws Exception{
	
	FcmResponse response=new FcmResponse();

log.info("Customer Confirm Booking From App-->bookingId-->"+pos.getRefPostId()+"-->SourceLat-->"+pos.getsLat()+"-->SourceLong-->"+pos.getsLong()+"-->From City-->"+pos.getFromCity()+"-->To City-->"+pos.getToCity()+"-->Travel Date-->"+pos.getTravelDate()+"-->Truck Type-->"+pos.getTruckTypeId());	
	
//Update Status of the Booking to Customer Confirmed

TruckInfo info=new TruckInfo();
info.setTruckId(pos.getTruckTypeId());
pos.setInfoTruck(info);

response=driverservice.updateBookingSatatus(pos);

if(response.getStatusCode()==404||response.getStatusCode()==500){

	return new ResponseEntity<FcmResponse>(response, HttpStatus.OK);
}
	// Send  Push Notification to the Nearest Driver 

LocalDriver driver=driverservice.getDriverForPushNotification(pos);
log.info("Notification Send to DriverId-->"+driver.getDriverName());
if(driver.getDriverId()==0){
	
	response.setStatusCode(204);
	response.setStatusMessage("No Driver Found");
	return new ResponseEntity<FcmResponse>(response, HttpStatus.OK);
}


return new ResponseEntity<FcmResponse>(response, HttpStatus.OK);

}







@RequestMapping(value = "/driver/uploadFile", method = RequestMethod.POST)
public ResponseEntity<String> getDriverImage(@RequestParam("file") CommonsMultipartFile file,
		@RequestParam("date") String date, @RequestParam("status") String status,
		@RequestParam("driverId") int driverId, @RequestParam("odometer") int odometer, HttpSession session)
		throws Exception {

	Log.info("Driver Rest Controller-->Fileupload method");
	DriverAppResponse res = new DriverAppResponse();
	ServletContext context = session.getServletContext();

	
	
	
	String filename = status.toUpperCase()+"."+"png";
	
	log.info("Diver Controller-->FileUpload Method-->Filename is :" + filename + "  date--->" + date
			+ "  driver Id -->" + driverId + " status--> " + status + " odometer reading=>" + odometer);

	String directory = context.getRealPath(UPLOAD_DIRECTORY) + File.separator + driverId;
	
	log.info(directory);
	// Create the directory if it does not exist
	File dir = new File(directory);
	if (!dir.exists()) {
		dir.mkdir();
		directory=directory+File.separator +date;
		File dir2 = new File(directory);
		if(!dir2.exists()){
			dir2.mkdir();
		} 
		
	} else{
	
		directory=directory+File.separator +date;
		File dir2 = new File(directory);
		if(!dir2.exists()){
			dir2.mkdir();
		}
		
	}
	if(driverId==0 && file.isEmpty() && status.isEmpty() && odometer==0){
		return new ResponseEntity<String>("not uploaded",HttpStatus.NOT_FOUND);
	}
	else{
	
		
	
	byte[] bytes = file.getBytes();
	BufferedOutputStream stream = new BufferedOutputStream(
			new FileOutputStream(new File(directory + File.separator + filename)));
	stream.write(bytes);
	stream.flush();
	stream.close();
	res=driverservice.imageuploadform(date,driverId,status,odometer);
	return new ResponseEntity<String>("Image uploaded successfully", HttpStatus.OK);
	// return new ResponseEntity<DriverAppResponse>(res,HttpStatus.OK);
	}
}





/*// Hack code to get file extension
String extension = file.getOriginalFilename();
String[] sa = extension.split("\\.");
extension = sa.length >=2 ? "." + sa[sa.length-1] : "";

String fileNamewithoutExtension=sa[0];
String ofilename=fileNamewithoutExtension+"."+"png";

System.out.println("OriginalFile-->"+extension);
System.out.println(sa[0]);

System.out.println("Output file"+ofilename);
*/














		
}