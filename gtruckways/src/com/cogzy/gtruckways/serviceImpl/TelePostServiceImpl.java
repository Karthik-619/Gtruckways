package com.cogzy.gtruckways.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ModelAndView;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.CustomerPayment;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.DriverDetailsResponse;
import com.cogzy.gtruckways.businessObjects.DriverTripDetailsResponse;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.Invoice;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.Telecaller;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.daoImpl.DriverDaoImpl;
import com.cogzy.gtruckways.daoImpl.PostDaoImpl;
import com.cogzy.gtruckways.daoImpl.TelePostDaoImpl;
import com.cogzy.gtruckways.service.TelePostService;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.AddtionalPricePojo;


@Configuration
@PropertySource(value="/price.properties",ignoreResourceNotFound=true)
public class TelePostServiceImpl implements TelePostService {

	TelePostDaoImpl PostDao;
	
	DriverDaoImpl driverdao;
	
	
	
	
	
	
	@Autowired
	GetPriceServiceImpl priceservice;
	
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	private static DecimalFormat df2 = new DecimalFormat(".##");
	public DriverDaoImpl getDriverdao() {
		return driverdao;
	}

	public void setDriverdao(DriverDaoImpl driverdao) {
		this.driverdao = driverdao;
	}

	public TelePostDaoImpl getPostDao() {
		return PostDao;
	}

	public void setPostDao(TelePostDaoImpl postDao) {
		PostDao = postDao;
	}


	

	public List<Post> getPostDetails() {
		
		List<Post> pos=PostDao.getPostDetails();
		return pos;
	}

	
	
	public Post getPostInformation(String PostId) {
		Post ps =new Post();
		try{
		
		ps=PostDao.getPostInformation(PostId);
		return ps;
		
		} catch(Exception e){
		
			ps.setStatusCode(404);
			return ps;	
		}
	
	}
	
	public List<TruckInfo> getTruckInfoDetails() {
		
		List<TruckInfo> trk=PostDao.getTruckInfoDetails();
		return trk;
	}
	
	
	
	public  CustomerPayment	getCustomerPaymentInfo(int PostId){
		
		
		CustomerPayment cp=PostDao.getCustomerPaymentInfo(PostId);
		return cp;
	}
	
	public  int	updatePostDetails(Post pos){
		
		int status=PostDao.updatePostDetails(pos);
		return status;
	}
	
	public  int	getAccountsId(int UserId){
		
		int status=PostDao.getAccountsId(UserId);
		return status;
	}
	
	public  int	addToAccounts(int UserId){
		
		int status=PostDao.addToAccounts(UserId);
		return status;
	}
	
	public int	updateCancel(Post pos){
		
		int status=PostDao.updateCancel(pos);
		return status;
	}
	
	public float updateTotalAmountAfterPayment(Post pos,float totalAmount){
		
		float otherAmount=0;
		
		log.info("Previou Total AMount"+pos.getTotalAmount());
		
		
		
			
			
		if(totalAmount>pos.getTotalAmount()){
			
			
			otherAmount=totalAmount-pos.getTotalAmount();
			
			pos.setOtherAmount(otherAmount);
			pos.setDiscountAmount(0);
			
		}else if(totalAmount<pos.getTotalAmount()){
			
			
			otherAmount=pos.getTotalAmount()-totalAmount;
			pos.setOtherAmount(0);
			pos.setDiscountAmount(otherAmount);
		}
		
		float gst=0;
		
		log.info("GST number of Customer-->"+pos.getUser().getGstNumber());
		
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
		
		float gtruckwaysAmount=(float) (totalAmount*0.07);  // 7% Commision
		
		float driverAmount=totalAmount-gtruckwaysAmount;
	
		pos.setGtruckwaysAmount(gtruckwaysAmount);
		pos.setDriverAmount(driverAmount);
		pos.setTotalAmount(totalAmount);
		
		
		
		
		log.info("Other Amount-->"+pos.getOtherAmount());
		
		int status=PostDao.updateCustomerPayment(pos);
		
		return totalAmount;
	}
	
	
	public int	addFinancialTransaction(CustomerPayment cp,int AccId){
		
		int status=PostDao.addFinancialTransaction(cp,AccId);
		return status;
	}
	
	public int	addAccountReceivable(CustomerPayment cp,int AccId, int transactionId){
		
		int status=PostDao.addAccountReceivable(cp,AccId,transactionId);
		return status;
	}
	
	public int addPayment(CustomerPayment cp,int transactionId,int AccId,int accRecevableId){
		
		int status=PostDao.addPayment(cp,transactionId,AccId,accRecevableId);
		return status;
	}
	
	public String checkStatus(String Postid) {
		
		String ps=PostDao.checkStatus(Postid);
		return ps;
	} 
	
	public int srcReached(Post pos) {
		
		int ps=PostDao.srcReached(pos);
		
		LocalDateTime dt=LocalDateTime.now().withNano(0); 
		log.info("Driver Id will make to Sleep-->"+pos.getDriver().getDriverId());
		int success1= driverdao.updateDriverStatustoSleepOrActive(pos.getDriver().getDriverId(),"22",dt);
		
		return ps;
	} 
	
	public int updateLoad(Post pos){
		int ps=PostDao.updateLoad(pos);
		return ps;
	}
	
	public int destReached(Post pos) {
		
		int ps=PostDao.destReached(pos);
		return ps;
	} 
	
	public int checkPayment(int Postid) {
		
		int ps=PostDao.checkPayment(Postid);
		return ps;
	} 
	
	public int updateUnload(Post pos) {
		
		int ps=PostDao.updateUnload(pos);
		return ps;
	} 
	
	public Invoice getInvoiceDetails(int Postid) {
		
		Invoice inv=PostDao.getInvoiceDetails(Postid);
		return inv;
	}

public Invoice getCancelationInvoiceDetails(String Postid) {
		
		Invoice inv=PostDao.getCancelationInvoiceDetails(Postid);
		log.info("accept time"+ inv.getPost().getAcceptedTime());
		
		if((inv.getPost().getAcceptedTime().equals("0") || inv.getPost().getSrcReachedDateTime().equals("0")) && inv.getStatusCode()==404){
			log.info("Invoice cant Generate");
			inv.setStatusCode(404);
			return inv;
		}
		
		
		inv.setInvoiceDate(inv.getPost().getTravelDate());
		inv.setStatusCode(200);
		return inv;
	}
	
	@Override
	public Post updateAdditionalPrice(AddtionalPricePojo ap,Post pos) {
		
		try{
		
		pos=PostDao.getPostInformation(pos.getBookingId());		
			
		int totalTripTime=getTimeBetweenStartAndStop(pos.getSrcReachedDateTime(),pos.getUnloadingDateTime());
		float actualKm=ap.getActualKm();
		Route rt=new Route();
		rt.setDistance(actualKm);
		rt.setTime(totalTripTime);
	    
		
		Price price=priceservice.getTotalAmount(rt,pos.getInfoTruck());
		
		
		
		price.setOtherAmount(ap.getOtherAmount());
		
		AmountDetails amt=getFinalAmount(pos.getSrcReachedDateTime(),pos.getHelper(),price.getTotalAmount(),price.getInfo().getLabourPrice(),pos.getDiscountAmount(),price.getOtherAmount());
		
		/*float gst=(float) (totalAmount*0.05);
		totalAmount=totalAmount+gst;*/
		
		log.info("TelePostserviceImpl-->updateAdditionalPriceMethod-->totalAmount-->"+amt.getTotalAmount()+"-->NightCharges-->"+amt.getNightCharges());
		
		price.setTotalAmount(amt.getTotalAmount());
		pos.setStatus("Trip Finished");
		pos.setGstAmount(0);
		pos.setNightCharges(amt.getNightCharges());
		
		float helperAmount=pos.getHelper()*pos.getInfoTruck().getLabourPrice();
		pos.setHelperAmount(helperAmount);  //helper amount
			
		
		int sucess=PostDao.updatePostInformationAfterTripComplete(pos,price);
		if(sucess!=1){
			
			pos.setStatusCode(404);
			return pos;
			
		}
		
		pos=PostDao.getPostInformation(pos.getBookingId());	
		LocalDateTime date=LocalDateTime.now().withNano(0);
		
		int changeStatus=driverdao.updateDriverStatustoSleepOrActive(pos.getDriver().getDriverId(), "11",date);
		
		return pos;
		
		} catch(Exception e){
			
			pos.setStatusCode(404);
			return pos;
		}
		
	}	
		/*float transporterAmount=0;
		float gtruckwaysAmount=0;
		
		float totalAmount=pos.getTotalAmount()+pos.getAdditionalAmount();
		System.out.println("sdkjufihsreidlhtgfioesruht"+pos.getTotalAmount());
		pos.setApproximateAmount(pos.getTotalAmount());
		pos.setTotalAmount(totalAmount);
		
			gtruckwaysAmount=(float) (totalAmount*0.07);
			System.out.println("sdkjufihsreidlhtgfioesruht"+transporterAmount);
			transporterAmount=totalAmount-gtruckwaysAmount;
			System.out.println("sdkjufihsreidlhtgfioesruht"+gtruckwaysAmount);
			pos.setGtruckwaysAmount(gtruckwaysAmount);
			pos.setTransporterAmount(transporterAmount);
		
			
			pos=PostDao.getPostInformation(pos.getRefPostId());	
			
			//totalTripTime=(int) (totalTripTime+pos.getExtraMins());
			LocalDateTime datetime=LocalDateTime.now().withNano(0);
			float totalKm=(pos.getApproximateKm()+pos.getExtraKm());
			//int updateTripdetails=PostDao.updateTripDetailsAfterTripCompleteManualy(totalKm,totalTripTime,datetime, pos.getRefPostId());
			int changeStatus=driverdao.updateDriverStatustoSleepOrActive(pos.getDriver().getDriverId(), "11",datetime);*/
			
				
			
		
	
	@Override
	public List<Vehicle> getListTransporter(int truckId) {
		
		
		log.info("TelePostServiceImpl-->getListTransporter-->TruckId"+truckId);
		
		List<Vehicle> veh=PostDao.getListTransporter(truckId);
		
		if(veh.isEmpty())
		{
			return null;
		}
		else{
			return veh;
		}
		
	}
	
	@Override
	public Vehicle getDriverConfirmation(String bookingId) {
		
		Vehicle veh=PostDao.getDriverConfirmation(bookingId);	
		
		return veh;
	}

	@Override
	public boolean updateFeedback(String feedback, LocalDateTime feedbackDate,Post pos)  {
		String status=pos.getStatus();
		if(status.equals("Completed") || status.equals("Unloading Finished"))
		{
			int flag=PostDao.updateFeedback(feedback,feedbackDate,pos);
			if(flag!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}

		
	}

	@Override
	public int driverCanceledtheTrip(String bookingId, int driverId,int penaltyAmount) {

		LocalDateTime DateTime=LocalDateTime.now().withNano(0);
		LocalTime time=LocalTime.now().withNano(0);
		try{
			
		int success=0;
		Deductions ded=new Deductions();
		if(penaltyAmount==1){	
		
		ded.setCode("DED_CANCELLED");
		ded.setAmount(100);
		ded.setBookId(bookingId);
		ded.setDriverId(driverId);
		ded.setReason("");
		success=driverdao.addDeductions(ded,DateTime);
		
		} else{
			
			ded.setCode("DED_CANCELLED");
			ded.setAmount(0);
			ded.setBookId(bookingId);
			ded.setDriverId(driverId);
			ded.setReason("");
			success=driverdao.addDeductions(ded,DateTime);	
			
		}
		
		int success1=driverdao.updateDriverStatustoSleepOrActive(driverId,"44",DateTime);
		
		if(success==0||success1==0){
			
			return 0;
			}
		
		return 1;
		
		} catch(Exception e){
			
			return 0;
		}
	}

	@Override
	public int NoResponseFromDriver(String bookingId, int driverId) {

		LocalDateTime time=LocalDateTime.now().withNano(0);
		try{
		int success1=driverdao.updateDriverStatustoSleepOrActive(driverId,"44",time);
		
		
		if(success1==0){
			
			return 0;
		}
		
			return 1;
			
		} catch(Exception e){
			
			return 0;
		}
	}

	@Override
	public TripDetails getTripDetailsofBooking(String bookingId) {
		// TODO Auto-generated method stub
		TripDetails trip=new TripDetails();
		try{
		
	     trip=PostDao.getTripDetailsofBook(bookingId);
				
	     if(trip.getTotalKm()==0){
	    	
	    	 	return trip;
			}
			
			return trip;
			
			} catch(Exception e){
				
				return trip;
		}
		
	}
	
	@Override
	public DriverDetailsResponse getDriverDetails(String regNo) {
		DriverDetailsResponse resp=new DriverDetailsResponse();
	try{	
		 resp=PostDao.getDriverDetails(regNo);
		
		 if(resp.getDriverStatus().equals("22")){
			 
		 DriverDetailsResponse resp1=PostDao.getCityWhenDriverEnagage(resp.getDriverId()); 
		 resp.setFromCity(resp1.getFromCity());
		 resp.setToCity(resp1.getToCity());
		 
		 }
		 
		 if(resp.getStatusCode()==401)
		 	{
			 resp.setStatusCode(401);
			 resp.setStatusMessage("Location Not Found");
			return resp;
			}
		 
		 if(resp.getCurrentLat()==0||resp.getCuurentLong()==0){
			 
			resp.setStatusCode(204);
			resp.setStatusMessage("Location Not Found");
			return resp; 
			 
		 }
		 
		 String currentLocation=getAddressFromLatLong(resp.getCurrentLat(),resp.getCuurentLong());
		 
		 resp.setCurrentLocationName(currentLocation);
		 resp.setStatusCode(200);
		  resp.setStatusMessage("Location Found");

		
		return resp;
	}
	 catch(Exception e){

		 resp.setStatusCode(500);
		 resp.setStatusMessage("Internal Server Error");
		 return resp;
	}
	}
	
	
public String getAddressFromLatLong(double lat,double Long) throws IOException, JSONException{
		
	
	
	URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+Long+"&sensor=true&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8");
   
 
	 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
     conn.setRequestMethod("GET");
     String line, outputString = "";
     BufferedReader reader = new BufferedReader(
     new InputStreamReader(conn.getInputStream()));
     while ((line = reader.readLine()) != null) 
     {
         outputString += line;
     }
     
     JSONObject json = new JSONObject(outputString);
     JSONArray arrResults=json.getJSONArray("results");
     
     for(int i=0; i<arrResults.length(); i++)
     {
          JSONObject obj=arrResults.getJSONObject(i);
          String strAddress=obj.getString("formatted_address");
          
          if(strAddress.length()>0)
          {
            
             System.out.println("address is"+strAddress);
             
             return strAddress;
          }
      
          
         
     }
     
   
     return "Not_Found";
	
	
	
	
	}

@Override
public int updateDriverStatus(int driverId, int StatusId) {
	LocalDateTime time=LocalDateTime.now().withNano(0);
	String StatId=Integer.toString(StatusId);
	int success1=driverdao.updateDriverStatustoSleepOrActive(driverId,StatId,time);
	
	if(success1==0){
		
		return 404;
	}
	
	
	return 200;
	}

@Override
public List<Post> getTripResponseOfDriver(int driverId, String fromDate, String toDate) {
	// TODO Auto-generated method stub
	
	
	
	log.info("DriverId-->"+driverId);
	List<Post> resp=PostDao.getBookingsOfDriver(driverId, fromDate, toDate);
	
	/*for(DriverTripDetailsResponse tripResp: resp){
		
		incList=PostDao.getDriverIncentives(driverId, tripResp.getBookingId());
		dedList=PostDao.getDriverDeductions(driverId, tripResp.getBookingId());
		log.info(tripResp.getBookingId());
		
		for(Incentives inc:incList){
			
			
			
		}
		tripResp.setIncentives(incList);
		for(Deductions ded:dedList){
			log.info(ded.getAmount());
			
		}
		tripResp.setDeductions(dedList);
	}*/
	
	
	
	return resp;
}

@Override
public DriverTripDetailsResponse getIncentivesAndDeductions(int driverId, String bookingId) {

	DriverTripDetailsResponse tripResp=new DriverTripDetailsResponse();
	try{
	
	tripResp=PostDao.getParticularBookingDetails(driverId, bookingId);
	
	/*List<Incentives> incent=PostDao.getDriverIncentives(driverId, bookingId);
	
	List<Deductions> ded=PostDao.getDriverDeductions(driverId, bookingId);
	
	
	tripResp.setIncentives(incent);
	tripResp.setDeductions(ded);
	
	if(tripResp.getStatusCode()==404){
		tripResp.setStatusCode(404);
		tripResp.setStatusMessage("No Data Found");
		
	}
	
	int sumIncentives=PostDao.sumofIncetivesofBookId(driverId, bookingId);
	int sumDeductions=PostDao.sumofDeductionsofBookId(driverId, bookingId);
	
	int driverAmount=(int) ((tripResp.getTripEarnings()+sumIncentives)-sumDeductions);
	tripResp.setSumIncentives(sumIncentives);
	tripResp.setSumDeductions(sumDeductions);
	tripResp.setDriverAmount(driverAmount);*/
	
	
	tripResp.setStatusCode(200);
	tripResp.setStatusMessage("success");
	
	return tripResp;
	
	}catch(Exception e ){
		tripResp.setStatusCode(500);
		tripResp.setStatusMessage("Internal Server Error");
		return tripResp;
	}
}

@Override
public DriverTripDetailsResponse addDeductions(int dedAmount, String reason, DriverDetailsResponse driverResp,String bookingId) {
	
	DriverTripDetailsResponse tripresp=new DriverTripDetailsResponse();
	
	Deductions ded=new Deductions();
	try{
	ded.setAmount(dedAmount);
	ded.setReason(reason);
	ded.setCode("DED_OTHERS");
	ded.setDriverId(driverResp.getDriverId());
	ded.setBookId(bookingId);
	LocalDateTime deductionDate=LocalDateTime.now().withNano(0);
	
	int success=driverdao.addDeductions(ded, deductionDate);
	
	List<Deductions> listDed=PostDao.getDriverDeductions(driverResp.getDriverId(), bookingId);
	int sumDeductions=PostDao.sumofDeductionsofBookId(driverResp.getDriverId(), bookingId);
	tripresp.setDeductions(listDed);
	tripresp.setSumDeductions(sumDeductions);
	
	return tripresp;
	
	} catch(Exception e){
		
		tripresp.setStatusCode(500);
		return tripresp;
	}
}

@Override
public TripDetails getDailyKmAndMinsofVehicleRegNo(String fromDate, String toDate, String vehicleRegNo) {
	
	TripDetails dailytripInfo=new TripDetails();
	
	int check=PostDao.checkvehicleRegNo(vehicleRegNo);
	if(check==1){
		
	List<TripDetails> dailyInfo=PostDao.getDailyKmAndMinsofVehicleRegNo(fromDate, toDate, vehicleRegNo);
	
	dailytripInfo.setDailytripinfo(dailyInfo);
	dailytripInfo.setFromDate(fromDate);
	dailytripInfo.setToDate(toDate);
	dailytripInfo.setRegNo(vehicleRegNo);
	return dailytripInfo;
	
	} else{
		
		dailytripInfo.setToDate("999");
		dailytripInfo.setRegNo(vehicleRegNo);
		return dailytripInfo;
	}
	
	
}
	
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
public LiveTracking getBookWiseTracking(String bookingId, String srcReachedTime, String destReachedTime) {
	LiveTracking live=new LiveTracking();
	double dist=0;
	double distance=0;
	List<LiveTracking> lt1=new ArrayList<LiveTracking>();
	
	try{
		
		
	List<LiveTracking> lt=PostDao.getVehicleTracking(bookingId,srcReachedTime,destReachedTime);
	
	if(lt.isEmpty()){
		
		
		
		live.setDistance(0);
		live.setTimeMins(0);
		
		return live;
		
	}
	
	
	
	String date1=lt.get(0).getCurrentDate();
	log.info("date1-->"+date1);
	
	
	String date2=lt.get(lt.size()-1).getCurrentDate();
	log.info("date2-->"+date2);
	
	String[] d1=date1.split("\\s+");
	String[] d2=date2.split("\\s+");
	
	log.info("date1-->"+d1[0]);
	log.info("date1-->"+d1[1]);
	log.info("date2-->"+d2[0]);
	log.info("date2-->"+d2[1]);
	
	int time=getTimeBetweenStartAndStop(d1[1],d2[1]);

	log.info("time-->"+time);
		
	/*//LiveTracking live1=new LiveTracking();
	live1.setLatitude(lt.get(0).getLatitude());
	live1.setLongitude(lt.get(0).getLongitude());*/
	
	try{
	
		for(int i=0;i<lt.size();i++){
		
		log.info("-->Size"+lt.size()+"-->Latitude-->"+lt.get(i).getLatitude()+"-->Longitude-->"+lt.get(i).getLongitude());
		
		
	
		
			dist=live.distance(Double.parseDouble(lt.get(i).getLatitude()),Double.parseDouble(lt.get(i).getLongitude()),Double.parseDouble(lt.get(i+1).getLatitude()),Double.parseDouble(lt.get(i+1).getLongitude()));
		log.info("Distance b/w points1111111111111-->"+dist);
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
			log.info("Distance b/w points-->"+dist);
			
			distance=distance+dist;
			lt1.add(live1);
		
			
		} 
		
		}
		
		} catch(Exception e){
			
			
		}
		
		
	
		
	
		log.info("Total Distance-->"+distance);	
		if(distance==0){
			
			live.setLatitude(lt.get(0).getLatitude());
			live.setLongitude(lt.get(0).getLongitude());
			live.setCurrentTime(lt.get(0).getCurrentTime());
			lt1.add(live);
		}
	
		
		for(LiveTracking ltr:lt1){
			
			
			log.info("lat-->"+ltr.getLatitude()+"-->long"+ltr.getLongitude());
		}
		
		
		String dist1=df2.format(distance);
		distance=Double.parseDouble(dist1);
		live.setLivetrack(lt1);
		live.setTimeMins(time);
		live.setDistance(distance);
		return live;
		
		} catch(Exception e){
			
			live.setDistance(0);
			live.setTimeMins(0);
		
			return live;
			
			
		}


		}

@Override
public Telecaller checkTelecallerExistsorNot(String email, String password,String status) {
	
	Telecaller tname=new Telecaller();
	try{
	
	
		 tname=PostDao.checkTelecallerExistsorNot(email, password,status);
	
	
		return tname;
	
	} catch(Exception e){
		
		tname.setStatusCode(500);
		return null;
	}
}


public AmountDetails getFinalAmount(String sourceReachedTime,int helper,float amount,float helperPrice,float discount,float otherAmount){
	 
	
	int slab; 

	
	
	if(sourceReachedTime.contains("-")){
		
		log.info("Source Reached Field Contains Date and Time"+sourceReachedTime); 
		
		String[] sp=sourceReachedTime.split("\\s+");
		
		String[] s= sp[1].split(":");
		
		slab=Integer.parseInt(s[0]);
		
	}else{
		
		log.info("Source Reached Field Contains only Time");
		
		String[] s= sourceReachedTime.split(":");
		
		slab=Integer.parseInt(s[0]);
	}
	
	
	
	float nightCharges=0;

	log.info("Source Reached Time in which Hour-->"+slab);  
	
		if(((slab>=0 && slab<8) || (slab>=20 && slab<=23)) && helper!=0 ){
	 	   	 
			
			float normalAmount= amount+(helperPrice*helper);
			
	 		amount=(float) (normalAmount*1.5); 
	 		
	 		nightCharges= (amount-normalAmount);
			
	 		
	 	   } else if((slab>=0 && slab<8 ||slab>=20 && slab<=23) && helper==0){
	 		   
	 		  float normalAmount= amount;
	 		   amount=(float) (normalAmount*1.5);
	 		  nightCharges= (amount-normalAmount);
	 		  
	 	   }
	 	   else if(helper!=0){
	 		   
	 		  amount=amount+helperPrice*helper;
	 	   }

		amount=(amount-discount)+otherAmount;
		
		
		AmountDetails amt= new AmountDetails();
		amt.setTotalAmount(amount);
		amt.setNightCharges(nightCharges);
		return amt;
	


}

@Override
public Post getCustomerInformation(String infoId) {
	// TODO Auto-generated method stub
	
	if(infoId.startsWith("GTR")){
		
		
		
	} else{
		
		
		Post post=PostDao.getCustomerInformation(infoId);
		
		if(post.getStatusCode()==401 ){
			
			return post;
			
		}
		log.info("UserName-->"+post.getUser().getUserName());
		
		return post;
	}
	
	
	
	
	return null;
}

@Override
public User addCustomersManualy(User user) {
	
	User use=new User();
	int success=PostDao.insertCustomerManualy(user);
	
	if(success==1){
		
	use=PostDao.getCustomersInformationManualy(user);
		
	return use;
	}
	
	// TODO Auto-generated method stub
	use.setStatusCode(401);
	return use;
}

@Override
public Post getManualBookingProcess(Post post) {
	// TODO Auto-generated method stub
	
	
	
	Route route=priceservice.getGoogleDistanceAndTime(post.getFromCity(),post.getToCity());
	
	if (route.getFromCity().isEmpty() || route.getToCity().isEmpty() || route.getDistance() == 0) {

		post.setStatusCode(401);

	}
	
	
	TruckInfo	info = priceservice.getTruckInformationDetails(post.getTruckId());
	
	if(info.getTruckId()==1 || info.getTruckId()==6){
		
		 route.setTime(route.getTime()+30);
		
	}else{
		
		 route.setTime(route.getTime()+60);
	}
	
	
	Price	price = priceservice.getTotalAmount(route, info);
	
	post.setApproximateAmount(price.getTotalAmount());
	
	PromoCode promo=priceservice.CheckPromoCodeExistsOrNot(post.getPromocode(),price.getTotalAmount(),price,post.getTravelDate());
	
	
	AmountDetails amt=getFinalAmount(post.getTravelDate(),post.getHelper(),price.getTotalAmount(),price.getInfo().getLabourPrice(),promo.getDiscountAmount(),price.getOtherAmount());
	
	
	post.setPrice(price);
	post.setTotalAmount(amt.getTotalAmount());
	
	log.info("Total AMount-->"+amt.getTotalAmount()+"Promocode-->"+promo.getDiscountAmount()+"promocode message-->"+promo.getStatusMessage());
	
	post.setDiscountAmount(promo.getDiscountAmount());
	post.setStatusMessage(promo.getStatusMessage());
	return post;
}

@Override
public Post insertBookingInformation(Post pos) {

	
	if(pos.getDifferentRecepient()==1){
		
		pos.setRecepientName(pos.getRecepientName());
		pos.setRecepientMobile(pos.getRecepientMobile());
	
	} else
	{
		pos.setRecepientMobile(pos.getUser().getMobileNo());
		pos.setRecepientName(pos.getUser().getUserName());
		
	}
	
	LocalDateTime date=LocalDateTime.now().withNano(0);
	String dt=date.toString();
	
	pos.setPostDate(dt);
	
	log.info("PostId-->PostDate-->"+pos.getPostDate());
	int invoiceId=PostDao.getrandompostid();
	
	
	Log.info("Manual Booking-->Invoice-->"+invoiceId);
	
	
	String bookingId="GTR"+invoiceId;
	pos.setInvoiceId(invoiceId);
	pos.setBookingId(bookingId);
	pos.setBookedThrough("Web-Telecaller");
	pos.setStatus("Booking Accepted");
	int success=PostDao.savepostdetails(pos);
	
	if(success==1){
		
		pos.setStatusCode(200);
		return pos;
	}
	
	pos.setStatusCode(401);
	return pos;
}

@Override
public List<Post> getLandPageCustomers() {
	
	
List<Post> landCust =PostDao.getLandPageCustomers();


return landCust;
}

@Override
public int landPageStatus(int customerId,String status) {

	PostDao.updateLandPageStatus(customerId,status);
	
	return 1;
}



}
