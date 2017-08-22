package com.cogzy.gtruckways.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseOdometer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.SchedulingVehicle;
import com.cogzy.gtruckways.businessObjects.SeoFile;
import com.cogzy.gtruckways.businessObjects.SpareTruckInfo;
import com.cogzy.gtruckways.businessObjects.Vehicle;

import com.cogzy.gtruckways.valueObjects.EnterpriseRequestPojo;

public interface AccountManagerService {

	
	/*public String getEnterPriseName(String enterpriseName);*/
	
	public EnterpriseCustomer getEnterpriseDetails(String enterpriseName);
	
	
	public String updateEnterpriseDetails(EnterpriseRequestPojo ec);
	
	public int assignVehicleToEnterprise(EnterpriseTruckAssign eta,EnterpriseCustomer ecust);
	
	public List<SchedulingVehicle> getDailySchedulingInformation();
	
	public List<Vehicle> getTruckRegNo(int vehicleTypeId);
	
	List <EnterpriseCustomer> getAllEnterpriseNames();
	
	public int updateEnterpriseVehicleDetails(EnterpriseTruckAssign eta);
	
	public int EnterpriseVehicleContractCancel(String RegNo);
	
	public SpareTruckInfo getSpareVehicles(String vehicleType,String regNo);
	
	public int insertSpareTruckDetails(SpareTruckInfo spare,int entCustomerId);
	
	 public int reassignOfVehicle(String assignVehicle,String spareVehicle);
	 
	 public EnterpriseTripDetails getEnterprsiePaymentDetails(String startDate,String endDate,String enterpriseCustomerName);
	
	 public EnterpriseVehicleStatus getvehicleStatus(String entCustomerName);
	 
	 public EnterpriseOdometer getEnterpriseOdometerInformation(String fromDate, String toDate, String vehicleRegNo);
	 
	 public int updateEnterpriseOdometer(EnterpriseTripDetails trip);
	 
	 public LiveTracking getVehicleTracking(String vehicleRegNo, String date);
	 
	 public byte[] saveSeoImageInformation(SeoFile seo,InputStream str);
	 
	 public byte[] getImage(int imageId);
	 
	public List<SeoFile> getAllSeoImagesAndData();
	
	public int updateSeoInformation(SeoFile seo);
	
	public int deleteImages(int imageId);
	
}
