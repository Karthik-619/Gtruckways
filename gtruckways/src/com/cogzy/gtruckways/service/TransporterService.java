package com.cogzy.gtruckways.service;

import java.util.List;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LocalTransporter;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.TransConfirm;
import com.cogzy.gtruckways.businessObjects.Transporter;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.valueObjects.TeleAddTrucksInfo;
import com.cogzy.gtruckways.valueObjects.TrackTransporterRequestPojo;
import com.cogzy.gtruckways.valueObjects.TransporterRequestPojo;

public interface TransporterService {

	public List<LocalTransporter> getTransporterDetails();
	public LocalTransporter getTransMobDetails(String Mobile);
	public List<Vehicle> getVehicleDetailsByMob(String Mobile);
	public LocalTransporter getTransportDetails(int transId);
	public List<Vehicle> getVehicleDetails(int transId);
	public int SaveTransConfirm(int driverId, Post pos);
	
	public boolean checkValidTransId(int TransId);
	public boolean checkDuplicateVehicle(TeleAddTrucksInfo addTruck);
	public boolean checkDuplicateDriver(TeleAddTrucksInfo addTruck);
	public String AddNewTrucks(TeleAddTrucksInfo addTruck);
	public boolean checkDuplicateTransporter(TransporterRequestPojo trans);
	public int saveTransporter(TransporterRequestPojo trans);
	
	public List<EnterpriseCustomer> getEnterpriseDetails();
	public List<Post> getTransporterPayemntInformation(String fromDate,String toDate,String transporterId);
	public AmountDetails getTotalAmount(String fromDate,String toDate,String transporterId);
	
	public Vehicle getVehicleInformation(String vehRegNum);
	public Deductions getTransporterDeduction(Post p);
	public Incentives getTransporterIncentive(Post p);
}
