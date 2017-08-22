package com.cogzy.gtruckways.serviceImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogzy.gtruckways.businessObjects.DistancePojo;
import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseInvoice;
import com.cogzy.gtruckways.businessObjects.EnterpriseOdometer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.SchedulingVehicle;
import com.cogzy.gtruckways.businessObjects.SeoFile;
import com.cogzy.gtruckways.businessObjects.SpareTruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.daoImpl.AccountManagerDaoImpl;
import com.cogzy.gtruckways.service.AccountManagerService;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.EnterpriseRequestPojo;


@Service
public class AccountManagerServiceImpl implements AccountManagerService {

	@Autowired
	AccountManagerDaoImpl accountdao;
	
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	//private static DecimalFormat df3 = new DecimalFormat(".###");

	
	public AccountManagerDaoImpl getAccountdao() {
		return accountdao;
	}

	public void setAccountdao(AccountManagerDaoImpl accountdao) {
		this.accountdao = accountdao;
	}

	
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	@Override
	public EnterpriseCustomer getEnterpriseDetails(String enterpriseName) {
	
		
		EnterpriseCustomer ecust=accountdao.getEnterpriseInformation(enterpriseName);
		
		
		if(ecust.getStatusCode()==404||ecust.getStatusCode()==500){
			
			ecust.setStatusCode(204);
			ecust.setStatusMessage("No EnterPrise Found");
			log.info("Enterprise not exists");
			return ecust;
		}
		
		List<EnterpriseTruckAssign> assign=accountdao.getParticularEnterpriseVehicleDetails(ecust.getEnterpriseCustomerId());
		List<SpareTruckInfo> spare=accountdao.getSpareTruckofEnterprise(ecust.getEnterpriseCustomerId());
		
		if(assign.isEmpty()){
			
			ecust.setStatusCode(404);
			ecust.setSpareDetails(spare);
			ecust.setStatusMessage("No Vehicle");
			return ecust;
		}
		
		
		
		ecust.setSpareDetails(spare);
		ecust.setEntVehicleDetails(assign);
		ecust.setStatusCode(200);
		ecust.setStatusMessage("found");
		return ecust;
	}
	@Override
	public String updateEnterpriseDetails(EnterpriseRequestPojo er) {
		// TODO Auto-generated method stub
		

		EnterpriseCustomer ec=new EnterpriseCustomer();
		
		User user=new User();
		String password=user.getUserpassword();
		ec.setPassword(password);
		
		LocalDate today = LocalDate.now();
		 
		ec.setRegDate(today); 
		ec.setEnterpriseName(er.getEnterpriseName());
		ec.setContactPerson(er.getContactPerson());
		ec.setContactNumber(er.getEnterpriseMobile());
		ec.setEmail(er.getEnterpriseEmail());
		ec.setAddress(er.getEnterpriseAddress());
		ec.setStatus(er.getStatus());
		
		int success=accountdao.updateEnterpriseDetails(ec);
		if(success==1){
		
		return password;
	
		}
		
		return "";
		}
	/*@Override
	public int updateEnterpriseDetails(EnterpriseRequestPojo er) {
		// TODO Auto-generated method stub
		

		EnterpriseCustomer ec=new EnterpriseCustomer();
		
		User user=new User();
		ec.setPassword(user.getUserpassword());
		 LocalDate today = LocalDate.now();
		 
		ec.setRegDate(today); 
		ec.setEnterpriseName(er.getEnterpriseName());
		ec.setContactPerson(er.getContactPerson());
		ec.setContactNumber(er.getEnterpriseMobile());
		ec.setEmail(er.getEnterpriseEmail());
		ec.setAddress(er.getEnterpriseAddress());
		ec.setStatus(er.getStatus());
		
		int success=accountdao.updateEnterpriseDetails(ec);
		
		
		return success;
	}*/

	@Override
	public int assignVehicleToEnterprise(EnterpriseTruckAssign eta,EnterpriseCustomer ecust) {
		
	eta.setEnterpriseId(ecust.getEnterpriseCustomerId());	
	log.info(eta.getVehicleRegNo());
	int success=accountdao.assignTruckToEnterprise(eta);
	int success1=accountdao.updateVehicleStatus(eta.getVehicleRegNo());
	log.info(success1);
	if(success==0 || success1==0){
	return success;
	}
	
	return success;
		
	}

	@Override
	public List<SchedulingVehicle> getDailySchedulingInformation() {
		
	
		List<SchedulingVehicle> sch=accountdao.getDailySchedulingDetails();
		
		
		
		return sch;
	}

@Override
public List<Vehicle> getTruckRegNo(int vehicleTypeId) {
		
		List<Vehicle> vehi=accountdao.getTruckRegNo( vehicleTypeId);
	
				return vehi;
	}
	
	
@Override
public List<EnterpriseCustomer> getAllEnterpriseNames() {
	
	List<EnterpriseCustomer> ecust=accountdao.getAllEnterpriseNames();
	return ecust;
}

@Override
public int updateEnterpriseVehicleDetails(EnterpriseTruckAssign eta) {
	
	int success=accountdao.updateEnterpriseVehicleDetails(eta);
	
	if(success==1){
		
		return 200;
		
	}

	return 404;
}
	
	
@Override
public int EnterpriseVehicleContractCancel(String RegNo) {
	
int success=accountdao.EnterpriseVehicleContractCancel(RegNo);

log.info(success);
	
if(success==1){
		
	
		return 200;
		
	}

	return 404;
}

@Override
public SpareTruckInfo getSpareVehicles(String vehicleType,String regNo) {

	SpareTruckInfo  spare=new SpareTruckInfo();
	try{
		log.info(vehicleType);
	List<String> vehicleRegNo=accountdao.getSpareVehicles(vehicleType);
	
	if(vehicleRegNo.isEmpty()){
		
		spare.setStatusCode(200);
		spare.setAssignVehicleRegNo(regNo);
		spare.setSpareVehicleType(vehicleType);
		spare.setStatusMessage("No Vehicles Found");
		log.info("No spare Truck Found");
		return spare;
	}
	
	spare.setStatusCode(200);
	spare.setAssignVehicleRegNo(regNo);
	spare.setSpareVehicleType(vehicleType);
	spare.setVehicleRegNo(vehicleRegNo);
	
	return spare;
	
	}catch(Exception e){
		
		spare.setStatusCode(500);
		spare.setStatusMessage("Internal Server Error");
		return spare;
	}
}

@Override
public int insertSpareTruckDetails(SpareTruckInfo spare,int entCustomerId) {
	

	int success=accountdao.insertSpareTruckDetails(spare,entCustomerId);
	
	int success1=accountdao.updateSpareVehicleStatus(spare.getAssignVehicleRegNo(),spare.getSpareVehicleRegNo());
	
	return success;
}

@Override
public int reassignOfVehicle(String assignVehicle, String spareVehicle) {

int success=accountdao.reassignOfVehicle(assignVehicle, spareVehicle);

log.info(success);
	return success;
}

@Override
public EnterpriseTripDetails getEnterprsiePaymentDetails(String startDate, String endDate,
		String enterpriseCustomerName) {

	EnterpriseTripDetails payinfo=new EnterpriseTripDetails();
	
	EnterpriseCustomer ecust=accountdao.getEnterpriseInformation(enterpriseCustomerName);
	
	
	List<EnterpriseTripDetails> tripInfo=accountdao.getEnterpriseTripDetails(startDate, endDate, ecust.getEnterpriseCustomerId());
	List<EnterpriseInvoice>	invoiceInfo=accountdao.getEnterpriseVehicleDetails(startDate, endDate, ecust.getEnterpriseCustomerId());
	
	payinfo.setEnterpriseName(ecust.getEnterpriseName());
	payinfo.setEnterpriseCustomerId(ecust.getEnterpriseCustomerId());
	payinfo.seteTripdetails(tripInfo);
	payinfo.setInvoiceInfo(invoiceInfo);
	
	return payinfo;
}

@Override
public EnterpriseVehicleStatus getvehicleStatus(String entCustomerName) {
	
	
	EnterpriseVehicleStatus balance=new EnterpriseVehicleStatus();
	
	EnterpriseCustomer ecust=accountdao.getEnterpriseInformation(entCustomerName);
	

	List<EnterpriseVehicleStatus> balanceList=accountdao.getvehicleStatus(ecust.getEnterpriseCustomerId());
	
	List<EnterpriseVehicleStatus> locationList=accountdao.getVehicleLocation(ecust.getEnterpriseCustomerId());
	
	
	balance.setVehiclebalStatus(balanceList);
	balance.setEnterpriseCustomerId(ecust.getEnterpriseCustomerId());
	balance.setEnterpriseName(ecust.getEnterpriseName());
	balance.setLocationStatus(locationList);
	
	return balance;
}
	
	
	
@Override
public EnterpriseOdometer getEnterpriseOdometerInformation(String fromDate, String toDate, String vehicleRegNo) {
	// TODO Auto-generated method stub
	
	
	EnterpriseOdometer odometer=accountdao.getEnterpriseOdomterinformation(vehicleRegNo);
	
	List<EnterpriseTripDetails> odometerList=accountdao.getOdometerReadings(fromDate, toDate, vehicleRegNo);
	
	log.info("odometerlist"+odometerList);
	
	for(EnterpriseTripDetails odo: odometerList){
		
		System.out.println("StartReading"+odo.getStartReading());
		System.out.println("EndReading"+odo.getEndReading());
	}
	
	odometer.setOdometerReadings(odometerList);
	odometer.setFromDate(fromDate);
	odometer.setToDate(toDate);
	odometer.setVehicleRegNo(vehicleRegNo);
	
	return odometer;
}

@Override
public int updateEnterpriseOdometer(EnterpriseTripDetails trip) {

	try{
	
	EnterpriseTripDetails tripinfo=accountdao.getEnterpriseOdometerReadings(trip.getTripDate(),trip.getEnterpriseCustomerId());
	
	if(tripinfo.getStartReading()!=trip.getStartReading() || tripinfo.getEndReading()!=trip.getEndReading()){
		
	float todayreading1=trip.getEndReading()-trip.getStartReading();
	float todayreading;
	int balance=accountdao.getminimumBalanceKm(trip.getEnterpriseCustomerId());
	int distance=accountdao.getMaxDistanceTravelled(trip.getEnterpriseCustomerId());
		
	if( todayreading1<0){
	
			
			
			todayreading=todayreading1+tripinfo.getTodayKm();
			float distancetravlled=distance-todayreading;
			float balanceKm=balance+todayreading;
			int s=accountdao.updateEnterprisedetails(trip.getStartReading(),trip.getEndReading(),distancetravlled, balanceKm, todayreading1, trip.getTripDate(), trip.getEnterpriseCustomerId());
			return 200;
			
		} else{

			
		todayreading=todayreading1-tripinfo.getTodayKm();
		float distancetravlled=distance+todayreading;
		float balanceKm=balance-todayreading;
		int s=accountdao.updateEnterprisedetails(trip.getStartReading(),trip.getEndReading(),distancetravlled, balanceKm, todayreading1, trip.getTripDate(), trip.getEnterpriseCustomerId());
		
		return 200;
		}
	}
	
	return 200;
	
	} catch(Exception e){
		
		
		return 500;
	}
	
	
	
}

@Override
public LiveTracking getVehicleTracking(String vehicleRegNo, String date) {
	// TODO Auto-generated method stub
	
	
	LiveTracking live=new LiveTracking();
	double dist=0;
	double distance=0;
	
	List<LiveTracking> lt1=new ArrayList<LiveTracking>();
	
	try{
		
		
	List<LiveTracking> lt=accountdao.getVehicleTracking(vehicleRegNo,date);
	
	if(lt.isEmpty()){
		
		
		
		live.setDistance(0);
		live.setTimeMins(0);
		live.setCurrentDate(date);
		live.setVehicleRegNo(vehicleRegNo);
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
		

	try{
		for(int i=0;i<lt.size();i++){
		
		log.info("-->Size"+lt.size()+"-->Latitude-->"+lt.get(i).getLatitude()+"-->Longitude-->"+lt.get(i).getLongitude()+"Time-->"+lt.get(i).getCurrentTime());
		
		
		
		
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
			log.info("Distance-->"+dist);
			
			distance=distance+dist;
			
			lt1.add(live1);
			
			
		} 
		
	
		}
		
		} catch(Exception e){
			
			
		}
		
		
	
		
		
		if(distance==0){
			
			live.setLatitude(lt.get(0).getLatitude());
			live.setLongitude(lt.get(0).getLongitude());
			live.setCurrentTime(lt.get(0).getCurrentTime());
			lt1.add(live);
		}
	
		
		for(LiveTracking ltr:lt1){
			
			
			log.info("lat-->"+ltr.getLatitude()+"-->long"+ltr.getLongitude()+"Time-->"+ltr.getCurrentTime());
		}
		
		
		String dist1=df2.format(distance);
		distance=Double.parseDouble(dist1);
		live.setLivetrack(lt1);
		live.setTimeMins(time);
		live.setDistance(distance);
		live.setCurrentDate(date);
		live.setVehicleRegNo(vehicleRegNo);
		
		return live;
		
		} catch(Exception e){
			
			live.setDistance(0);
			live.setTimeMins(0);
			live.setCurrentDate(date);
			live.setVehicleRegNo(vehicleRegNo);
			return live;
			
			
		}
	
	

}
	
	
	
	
	
	
	
	
	/*public static AccountManagerServiceImpl instance = new AccountManagerServiceImpl();
	TreeMap<String, EnterpriseCustomer> enterpriseCache = new TreeMap<String, EnterpriseCustomer>(String.CASE_INSENSITIVE_ORDER);
	
	
	private AccountManagerServiceImpl() {
		
		getEnterPriseName();
	}
	
	public static AccountManagerServiceImpl getHelper() {
		return instance;
	}
	
	
	
	public void getEnterPriseName() {
	
		try{
	
		enterpriseCache=accountdao.getEnterPriseName();
		
		} catch(Exception e) {
			//TODO proper exception handling
			e.printStackTrace();
		}
		
		
	}

	
	public Collection<EnterpriseCustomer> prefixSearch(String prefix) {
		SortedMap<String, EnterpriseCustomer> smp = enterpriseCache.subMap(prefix, prefix + Character.MAX_VALUE);
		return smp.values();
	}
	*/
	



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
		public byte[] saveSeoImageInformation(SeoFile seo, InputStream str) {
			
			accountdao.saveSeoImageInformation(seo,str);
			
			byte[] b=new byte[5];
			
			log.info("Byte-->"+b);
			
			return b;
		}

		@Override
		public byte[] getImage(int imageId) {
			
			byte[] b=accountdao.getImageFromDatabase(imageId);
			
			
			return b;
		}

		@Override
		public List<SeoFile> getAllSeoImagesAndData() {
			
			List<SeoFile> seo=accountdao.getAllSeoImagesAndData();
			return seo;
		}

		@Override
		public int updateSeoInformation(SeoFile seo) {
			
			
			int success=accountdao.updateSeoInformation(seo);
			
			return success;
			
		}

		@Override
		public int deleteImages(int imageId) {


			
		int success=accountdao.deleteImages(imageId);
		
		return success;
		
		
		}
		


		














	
}
