package com.cogzy.gtruckways.dao;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.TreeMap;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseInvoice;
import com.cogzy.gtruckways.businessObjects.EnterpriseOdometer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.SchedulingVehicle;
import com.cogzy.gtruckways.businessObjects.SeoFile;
import com.cogzy.gtruckways.businessObjects.SpareTruckInfo;
import com.cogzy.gtruckways.businessObjects.Vehicle;

public interface AccountManagerDao {

	public TreeMap<String,EnterpriseCustomer> getEnterPriseName();

	
	public EnterpriseCustomer getEnterpriseInformation(String enterpriseName);
	
	public int updateEnterpriseDetails(EnterpriseCustomer ec);
	
	public int assignTruckToEnterprise(EnterpriseTruckAssign assign);
	
	
	public List<SchedulingVehicle> getDailySchedulingDetails();
	
	public List<Vehicle> getTruckRegNo(int vehicleTypeId);
	
	public List<EnterpriseTruckAssign> getParticularEnterpriseVehicleDetails(int enterpriseId);
	
	 public List<EnterpriseCustomer> getAllEnterpriseNames();
	 
	 public int updateEnterpriseVehicleDetails(EnterpriseTruckAssign eta); 
	 
	 public int EnterpriseVehicleContractCancel(String RegNo);
	 
	 public List<String> getSpareVehicles(String vehicleType);
	 
	 public int updateVehicleStatus(String regNo);
	 
	 public int insertSpareTruckDetails(SpareTruckInfo spare,int entCustomerId);
	 
	 public List<SpareTruckInfo> getSpareTruckofEnterprise(int entCustomerId);
	 
	 public int reassignOfVehicle(String assignVehicle,String spareVehicle);
	 
	public List<EnterpriseInvoice> getEnterpriseVehicleDetails(String startDate, String endDate,int entCustomerId); 
	
	public List<EnterpriseTripDetails> getEnterpriseTripDetails(String startDate, String endDate, int entCustomerId);
	
	public List<EnterpriseVehicleStatus> getvehicleStatus(int entCustomerId);
	
	 public List<EnterpriseVehicleStatus> getVehicleLocation(int entCustomerId);
	 
	 public List<EnterpriseTripDetails> getOdometerReadings(String fromDate, String toDate, String vehicleRegNo);
	 
	 public EnterpriseOdometer getEnterpriseOdomterinformation(String vehicleRegNo);
	 
	 public EnterpriseTripDetails getEnterpriseOdometerReadings(String tripdate, int entvehicleId);
	 
		public int updateEnterprisedetails(float start, float end, float distance, float balance, float todayKm,
				String tripDate, int entvehicleId);
		
		public int getminimumBalanceKm(int entvehicleId);
		
		public int getMaxDistanceTravelled(int entvehicleId);
		
		
	public List<LiveTracking> getVehicleTracking(String vehicleRegNo,String date);	
	
	
	public int saveSeoImageInformation(SeoFile seo,InputStream str);
	
	public byte[] getImageFromDatabase(int imageId);
	
	public List<SeoFile> getAllSeoImagesAndData();
	
	public int updateSeoInformation(SeoFile seo);

	public int deleteImages(int imageId);

}
