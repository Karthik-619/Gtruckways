package com.cogzy.gtruckways.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.LocalTransporter;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.TransConfirm;
import com.cogzy.gtruckways.businessObjects.Transporter;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;

public interface TransporterDao {

	public List<LocalTransporter> getTransporterDetails();
	public LocalTransporter getTransMobDetails(String Mobile);
	public List<Vehicle> getVehicleDetailsByMob(String Mobile);
	public LocalTransporter getTransportDetails(int transId);
	public List<Vehicle> getVehicleDetails(int transId);
	public int SaveTransConfirm(int driverId, Post pos);
	public int saveTransporter(Transporter trans,LocalDateTime dt, int active);
	public boolean checkDuplicateTransporter(Transporter trans);
	public boolean checkDuplicateVehicle(Vehicle veh);
	public boolean checkDuplicateDriver(LocalDriver LocDriver);
	int AddToDriverVehicle(LocalDriver locDriver, Vehicle veh, int TransporterId,int truckId,LocalDateTime datetime);
	public List<Post> getTransporterPaymentInformation(String fromDate,String toDate,String transporterId);
	public AmountDetails getAllTotalAmount(String fromDate,String toDate,int transporterId);
	public List<Post> getAllTransporterPaymentInformation(String fromDate,String toDate);
	public Deductions getTransporterDeduction(Post p);
	public Incentives getTransporterIncentive(Post p);
	public int getTrcukId(String VehicleName);
}
